package com.easyrecruit.management.service.impl;

import com.easyrecruit.management.dal.entity.CandidateEntity;
import com.easyrecruit.management.dal.entity.RecruiterEntity;
import com.easyrecruit.management.dal.repository.RecruiterRepository;
import com.easyrecruit.management.infra.model.entity.Candidate;
import com.easyrecruit.management.infra.model.entity.Recruiter;
import com.easyrecruit.management.infra.model.payload.request.RecruiterCreateOrUpdateRequest;
import com.easyrecruit.management.infra.model.payload.response.DeleteResponse;
import com.easyrecruit.management.service.api.RecruiterModule;
import com.easyrecruit.management.service.api.exception.CRUDOperationException;
import com.easyrecruit.management.service.impl.converter.RecruiterConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecruiterModuleImpl implements RecruiterModule {

    @Autowired
    private RecruiterRepository repository;

    @Override
    public Recruiter createRecruiter(RecruiterCreateOrUpdateRequest request) throws CRUDOperationException {

        Recruiter recruiter = new Recruiter()
                .setFirstname(request.firstname())
                .setLastname(request.lastname())
                .setDepartment(request.department())
                .setTitle(request.title());

        RecruiterEntity recruiterEntity = RecruiterConverter.INSTANCE.toEntity(recruiter);
        repository.save(recruiterEntity);

        return recruiter;
    }

    @Override
    public Recruiter updateRecruiter(RecruiterCreateOrUpdateRequest request, String recruiterUuid) throws CRUDOperationException {
        return null;
    }

    @Override
    public DeleteResponse deleteRecruiter(Recruiter Recruiter) throws CRUDOperationException {
        return null;
    }


    @Override
    public DeleteResponse deleteRecruiter(String RecruiterUuid) throws CRUDOperationException {
        return null;
    }

    @Override
    public Recruiter getRecruiterByUuid(String uuid) throws CRUDOperationException {
        return null;
    }

    @Override
    public Recruiter getRecruiterByEmail(String email) throws CRUDOperationException {
        return null;
    }

    @Override
    public List<Recruiter> getRecruiterByFullname(String fullname) throws CRUDOperationException {
        return List.of();
    }

    @Override
    public List<Recruiter> getRecruiterByFirstname(String firstname) throws CRUDOperationException {
        return List.of();
    }

    @Override
    public List<Recruiter> getRecruiterByLastname(String lastname) throws CRUDOperationException {
        return List.of();
    }

    @Override
    public List<Recruiter> getAllRecruiters() throws CRUDOperationException {
        return List.of();
    }

    @Override
    public DeleteResponse deleteAllRecruiters() throws CRUDOperationException {
        return null;
    }
}
