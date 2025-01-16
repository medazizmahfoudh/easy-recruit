package com.easyrecruit.management.service.api;

import com.easyrecruit.management.infra.model.entity.Recruiter;
import com.easyrecruit.management.infra.model.payload.request.RecruiterCreateOrUpdateRequest;
import com.easyrecruit.management.infra.model.payload.response.DeleteResponse;
import com.easyrecruit.management.service.api.exception.CRUDOperationException;

import java.util.List;

public interface RecruiterModule {

    Recruiter createRecruiter(RecruiterCreateOrUpdateRequest request) throws CRUDOperationException;
    Recruiter updateRecruiter(RecruiterCreateOrUpdateRequest request, String recruiterUuid) throws CRUDOperationException;
    DeleteResponse deleteRecruiter(Recruiter Recruiter) throws CRUDOperationException;
    DeleteResponse deleteRecruiter(String RecruiterUuid) throws CRUDOperationException;
    Recruiter getRecruiterByUuid(String uuid) throws CRUDOperationException;
    List<Recruiter> getRecruiterByFullname(String fullname) throws CRUDOperationException;
    List<Recruiter> getRecruiterByFirstname(String firstname) throws CRUDOperationException;
    List<Recruiter> getRecruiterByLastname(String lastname) throws CRUDOperationException;
    List<Recruiter> getAllRecruiters() throws CRUDOperationException;
    DeleteResponse deleteAllRecruiters() throws CRUDOperationException;
    DeleteResponse deleteRecruiterBulkByUuid(List<String> interviewUuids);
}
