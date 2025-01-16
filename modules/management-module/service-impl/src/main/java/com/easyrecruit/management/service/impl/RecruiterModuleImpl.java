package com.easyrecruit.management.service.impl;

import com.easyrecruit.management.dal.entity.RecruiterEntity;
import com.easyrecruit.management.dal.repository.RecruiterRepository;
import com.easyrecruit.management.infra.model.entity.Recruiter;
import com.easyrecruit.management.infra.model.payload.request.RecruiterCreateOrUpdateRequest;
import com.easyrecruit.management.infra.model.payload.response.DeleteResponse;
import com.easyrecruit.management.infra.model.payload.response.OperationStatus;
import com.easyrecruit.management.service.api.RecruiterModule;
import com.easyrecruit.management.service.api.exception.CRUDOperation;
import com.easyrecruit.management.service.api.exception.CRUDOperationException;
import com.easyrecruit.management.service.impl.converter.RecruiterConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RecruiterModuleImpl implements RecruiterModule {

    @Autowired
    private RecruiterRepository repository;

    @Override
    public Recruiter createRecruiter(RecruiterCreateOrUpdateRequest request) throws CRUDOperationException {

        Recruiter recruiter = new Recruiter()
                .setFirstname(request.firstname().toLowerCase())
                .setLastname(request.lastname().toLowerCase())
                .setDepartment(request.department())
                .setTitle(request.title());

        RecruiterEntity recruiterEntity = RecruiterConverter.INSTANCE.toEntity(recruiter);
        repository.save(recruiterEntity);

        return recruiter;
    }

    @Override
    public Recruiter updateRecruiter(RecruiterCreateOrUpdateRequest request, String recruiterUuid) throws CRUDOperationException {
        Optional<RecruiterEntity> existingRecruiter = repository.getRecruiterEntityByUuid(UUID.fromString(recruiterUuid));
        if (existingRecruiter.isEmpty()) {
            throw new CRUDOperationException(CRUDOperation.UPDATE, "Recruiter with the given uuid not found.");
        }

        Recruiter recruiter = RecruiterConverter.INSTANCE.fromEntity(existingRecruiter.get());
        recruiter
                .setFirstname(request.firstname())
                .setLastname(request.lastname())
                .setDepartment(request.department())
                .setTitle(request.title());

        repository.save(RecruiterConverter.INSTANCE.toEntity(recruiter));

        return recruiter;
    }

    @Override
    public DeleteResponse deleteRecruiter(Recruiter recruiter) throws CRUDOperationException {
        repository.delete(RecruiterConverter.INSTANCE.toEntity(recruiter));
        return new DeleteResponse(OperationStatus.SUCCESS, "Recruiter has been deleted.");
    }

    @Override
    public DeleteResponse deleteRecruiter(String recruiterUuid) throws CRUDOperationException {
        Optional<RecruiterEntity> recruiterEntity = repository.getRecruiterEntityByUuid(UUID.fromString(recruiterUuid));
        if (recruiterEntity.isEmpty()) {
            throw new CRUDOperationException(CRUDOperation.READ, "Recruiter for the given uuid doesn't exist");
        }
        repository.delete(recruiterEntity.get());
        return new DeleteResponse(OperationStatus.SUCCESS, "Recruiter has been deleted.");
    }

    @Override
    public Recruiter getRecruiterByUuid(String uuid) throws CRUDOperationException {
        Optional<RecruiterEntity> recruiterEntity = repository.getRecruiterEntityByUuid(UUID.fromString(uuid));
        if (recruiterEntity.isEmpty()) {
            throw new CRUDOperationException(CRUDOperation.READ, "Recruiter for the given uuid doesn't exist");
        }
        return RecruiterConverter.INSTANCE.fromEntity(recruiterEntity.get());
    }

    @Override
    public List<Recruiter> getRecruiterByFullname(String fullname) throws CRUDOperationException {
        String[] nameParts = getStrings(fullname);

        String firstname = nameParts[0].toLowerCase();
        String lastname = nameParts[1].toLowerCase();

        List<RecruiterEntity> recruiterEntities = repository.getRecruiterEntityByFirstnameAndLastname(firstname, lastname);

        return recruiterEntities.stream()
                .map(RecruiterConverter.INSTANCE::fromEntity)
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
    public List<Recruiter> getRecruiterByFirstname(String firstname) throws CRUDOperationException {
        List<RecruiterEntity> recruiterEntities = repository.getRecruiterEntityByFirstname(firstname.toLowerCase());
        return recruiterEntities.stream().map(RecruiterConverter.INSTANCE::fromEntity).toList();
    }

    @Override
    public List<Recruiter> getRecruiterByLastname(String lastname) throws CRUDOperationException {
        List<RecruiterEntity> recruiterEntities = repository.getRecruiterEntityByLastname(lastname.toLowerCase());
        return recruiterEntities.stream().map(RecruiterConverter.INSTANCE::fromEntity).toList();
    }

    @Override
    public List<Recruiter> getAllRecruiters() throws CRUDOperationException {
        List<RecruiterEntity> recruiterEntities = repository.findAll();
        return recruiterEntities.stream().map(RecruiterConverter.INSTANCE::fromEntity).toList();
    }

    @Override
    public DeleteResponse deleteAllRecruiters() throws CRUDOperationException {
        repository.deleteAll();
        return new DeleteResponse(OperationStatus.SUCCESS, "All recruiters have been deleted.");
    }

    @Override
    public DeleteResponse deleteRecruiterBulkByUuid(List<String> interviewUuids) {
        interviewUuids.forEach(this::deleteRecruiter);
        return new DeleteResponse(OperationStatus.SUCCESS, "Recruiters deleted successfully.");
    }
}
