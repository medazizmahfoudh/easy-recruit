package com.easyrecruit.management.service.api;

import com.easyrecruit.management.infra.model.entity.Application;
import com.easyrecruit.management.infra.model.payload.request.ApplicationSubmitOrUpdateRequest;
import com.easyrecruit.management.infra.model.payload.response.DeleteResponse;
import com.easyrecruit.management.service.api.exception.CRUDOperationException;

import java.util.List;

public interface ApplicationModule {

    Application createApplication(ApplicationSubmitOrUpdateRequest request) throws CRUDOperationException;
    Application getApplicationByUuid(String uuid) throws CRUDOperationException;
    Application updateApplicationStatus(String applicationUuid, Integer applicationStatus) throws CRUDOperationException;
    Application getApplicationByCandidateUuidAndPositionUuid(String candidateUuid, String positionUuid) throws CRUDOperationException;
    List<Application> getApplicationsByCandidateFirstname(String firstname) throws CRUDOperationException;
    List<Application> getApplicationsByCandidateLastname(String lastname) throws CRUDOperationException;
    List<Application> getApplicationsByCandidateFullname(String fullname) throws CRUDOperationException;
    List<Application> getApplicationsByCandidateUuid(String candidateUuid) throws CRUDOperationException;
    List<Application> getApplicationsByPositionUuid(String positionUuid) throws CRUDOperationException;
    List<Application> getAllApplications() throws CRUDOperationException;
    DeleteResponse deleteApplication(String applicationUuid) throws CRUDOperationException;
    DeleteResponse deleteAllApplications() throws CRUDOperationException;

    // For evaluation module
    List<Application> getAllNewApplications();
}
