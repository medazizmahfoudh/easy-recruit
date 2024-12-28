package com.easyrecruit.management.service.api;

import com.easyrecruit.management.infra.model.entity.Candidate;
import com.easyrecruit.management.infra.model.payload.request.CandidateCreateOrUpdateRequest;
import com.easyrecruit.management.infra.model.payload.response.DeleteResponse;
import com.easyrecruit.management.service.api.exception.CRUDOperationException;

import java.util.List;

public interface CandidateModule {
    Candidate createCandidate(CandidateCreateOrUpdateRequest request) throws CRUDOperationException;
    Candidate updateCandidate(CandidateCreateOrUpdateRequest request, String candidateUuid) throws CRUDOperationException;
    DeleteResponse deleteCandidate(Candidate candidate) throws CRUDOperationException;
    DeleteResponse deleteCandidate(String candidateUuid) throws CRUDOperationException;
    Candidate getCandidateByUuid(String uuid) throws CRUDOperationException;
    Candidate getCandidateByEmail(String email) throws CRUDOperationException;
    List<Candidate> getCandidateByFullname(String fullname) throws CRUDOperationException;
    List<Candidate> getCandidateByFirstname(String firstname) throws CRUDOperationException;
    List<Candidate> getCandidateByLastname(String lastname) throws CRUDOperationException;
    List<Candidate> getAllCandidates() throws CRUDOperationException;
    DeleteResponse deleteAllCandidates() throws CRUDOperationException;
}
