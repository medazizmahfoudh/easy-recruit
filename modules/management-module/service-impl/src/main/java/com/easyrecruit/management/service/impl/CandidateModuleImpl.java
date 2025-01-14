package com.easyrecruit.management.service.impl;

import com.easyrecruit.management.dal.entity.CandidateEntity;
import com.easyrecruit.management.dal.repository.CandidateRepository;
import com.easyrecruit.management.infra.model.entity.Candidate;
import com.easyrecruit.management.infra.model.payload.request.CandidateCreateOrUpdateRequest;
import com.easyrecruit.management.infra.model.payload.response.DeleteResponse;
import com.easyrecruit.management.infra.model.payload.response.OperationStatus;
import com.easyrecruit.management.service.api.CandidateModule;
import com.easyrecruit.management.service.api.CvModule;
import com.easyrecruit.management.service.api.exception.CRUDOperation;
import com.easyrecruit.management.service.api.exception.CRUDOperationException;
import com.easyrecruit.management.service.impl.converter.CandidateConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CandidateModuleImpl implements CandidateModule {

    @Autowired
    private CandidateRepository repository;
    @Autowired
    private CvModule cvModule;


    @Override
    public Candidate getCandidateById(Long id) throws CRUDOperationException {
         return CandidateConverter.INSTANCE.fromEntity(
                 repository.getCandidateEntityById(id)
                         .orElseThrow(() -> new CRUDOperationException(CRUDOperation.READ, "Candidate not found.")));
    }

    @Override
    public Candidate createCandidate(CandidateCreateOrUpdateRequest request) throws CRUDOperationException {

        if (repository.existsByEmail(request.email())) {
            throw new CRUDOperationException(CRUDOperation.CREATE, "Candidate with the given name already exists");
        }

        Candidate candidate = new Candidate()
                .setFirstname(request.firstname().toLowerCase())
                .setLastname(request.lastname().toLowerCase())
                .setEmail(request.email());

        CandidateEntity candidateEntity = CandidateConverter.INSTANCE.toEntity(candidate);
        repository.save(candidateEntity);

        return candidate;
    }

    @Override
    public Candidate updateCandidate(CandidateCreateOrUpdateRequest request, String candidateUuid) throws CRUDOperationException {
        Optional<CandidateEntity> oldCandidateEntity = repository.getCandidateEntityByUuid(UUID.fromString(candidateUuid));
        if (oldCandidateEntity.isEmpty()) {
            throw new CRUDOperationException(CRUDOperation.UPDATE, "Candidate not found.");
        }

        Candidate candidate = CandidateConverter.INSTANCE.fromEntity(oldCandidateEntity.get());
        candidate
                .setEmail(request.email())
                        .setFirstname(request.firstname())
                                .setLastname(request.lastname());
        repository.save(CandidateConverter.INSTANCE.toEntity(candidate));

        return candidate;
    }

    @Override
    public DeleteResponse deleteCandidate(Candidate candidate) throws CRUDOperationException {
        repository.delete(CandidateConverter.INSTANCE.toEntity(candidate));
        return new DeleteResponse(OperationStatus.SUCCESS, "Resource has been deleted.");
    }

    @Override
    public DeleteResponse deleteCandidate(String candidateUuid) throws CRUDOperationException {
        Optional<CandidateEntity> candidateEntity = repository.getCandidateEntityByUuid(UUID.fromString(candidateUuid));
        if (candidateEntity.isEmpty()) {
            throw new CRUDOperationException(CRUDOperation.READ, "Candidate for the given uuid doesn't exist");
        }
        repository.delete(candidateEntity.get());
        return new DeleteResponse(OperationStatus.SUCCESS, "Resource has been deleted.");
    }

    @Override
    public Candidate getCandidateByUuid(String uuid) throws CRUDOperationException {
        Optional<CandidateEntity> candidateEntity = repository.getCandidateEntityByUuid(UUID.fromString(uuid));
        if (candidateEntity.isEmpty()) {
            throw new CRUDOperationException(CRUDOperation.READ, "Candidate for the given uuid doesn't exist");
        }
        return CandidateConverter.INSTANCE.fromEntity(candidateEntity.get());
    }

    @Override
    public Candidate getCandidateByEmail(String email) throws CRUDOperationException {
        Optional<CandidateEntity> candidateEntity = repository.getCandidateEntityByEmail(email);
        if (candidateEntity.isEmpty()) {
            throw new CRUDOperationException(CRUDOperation.READ, "Candidate for the given fullname doesn't exist");
        }
        return CandidateConverter.INSTANCE.fromEntity(candidateEntity.get());
    }

    @Override
    public List<Candidate> getCandidateByFullname(String fullname) throws CRUDOperationException {
        String[] nameParts = getStrings(fullname);



        String firstname = nameParts[0].toLowerCase();
        String lastname = nameParts[1].toLowerCase();

        List<CandidateEntity> candidateEntities = repository.getCandidateEntityByFirstnameAndLastname(firstname, lastname);

        return candidateEntities.stream()
                .map(CandidateConverter.INSTANCE::fromEntity)
                .toList();
    }

    private String[] getStrings(String fullname) {
        if (fullname == null || fullname.trim().isEmpty()) {
            throw new CRUDOperationException(CRUDOperation.READ, "Fullname cannot be empty.");
        }

        String sanitizedFullname = fullname.replaceAll("[^a-zA-Z ]", "");

        if (!sanitizedFullname.equals(fullname)) {
            throw new CRUDOperationException(CRUDOperation.READ, "Invalid character(s) found in fullname. Only alphabetic characters and spaces are allowed.");
        }

        String[] nameParts = sanitizedFullname.trim().split(" ");

        if (nameParts.length != 2) {
            throw new CRUDOperationException(CRUDOperation.READ, "Invalid fullname format. Please provide both first and last names.");
        }

        return nameParts;
    }


    @Override
    public List<Candidate> getCandidateByFirstname(String firstname) throws CRUDOperationException {
        List<CandidateEntity> candidateEntities = repository.getCandidateEntityByFirstname(firstname.toLowerCase());
        return candidateEntities
                .stream()
                .map(CandidateConverter.INSTANCE::fromEntity)
                .toList();
    }

    @Override
    public List<Candidate> getCandidateByLastname(String lastname) throws CRUDOperationException {
        List<CandidateEntity> candidateEntities = repository.getCandidateEntityByLastname(lastname.toLowerCase());
        return candidateEntities
                .stream()
                .map(CandidateConverter.INSTANCE::fromEntity)
                .toList();
    }

    @Override
    public List<Candidate> getAllCandidates() throws CRUDOperationException {
        return repository.findAll()
                .stream()
                .map(CandidateConverter.INSTANCE::fromEntity)
                .toList();
    }

    @Override
    public DeleteResponse deleteAllCandidates() throws CRUDOperationException {
        repository.deleteAll();
        cvModule.deleteAll();
        return new DeleteResponse(OperationStatus.SUCCESS, "Resource has been deleted.");
    }
}
