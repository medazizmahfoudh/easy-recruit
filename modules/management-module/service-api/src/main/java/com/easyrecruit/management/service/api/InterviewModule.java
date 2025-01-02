package com.easyrecruit.management.service.api;

import com.easyrecruit.management.infra.model.entity.Interview;
import com.easyrecruit.management.infra.model.payload.request.InterviewCreateOrUpdateRequest;
import com.easyrecruit.management.infra.model.payload.response.DeleteResponse;
import com.easyrecruit.management.service.api.exception.CRUDOperationException;

import java.util.List;

public interface InterviewModule {

    Interview createInterview(InterviewCreateOrUpdateRequest request) throws CRUDOperationException;
    Interview updateInterview(InterviewCreateOrUpdateRequest request, String uuid) throws CRUDOperationException;
    Interview getInterviewByUuid(String uuid);
    List<Interview> getAllInterviews();
    List<Interview> getInterviewsByCandidateUuid(String candidateUuid);
    List<Interview> getInterviewsByRecruiterUuid(String recruiterUuid);
    List<Interview> getInterviewsByPositionUuid(String positionUuid);
    Interview getInterviewByPositionUuidAndCandidateUuid(String positionUuid, String candidateUuid);
    List<Interview> getInterviewsByPositionUuidAndRecruiterUuid(String positionUuid, String recruiterUuid);
    List<Interview> getInterviewsByCandidateUuidAndRecruiterUuid(String candidateUuid, String recruiterUuid);
    DeleteResponse deleteInterviewByUuid(String Uuid);
    DeleteResponse deleteInterviewsByCandidateUuid(String candidateUuid);
    DeleteResponse deleteInterviewsByRecruiterUuid(String recruiterUuid);
    DeleteResponse deleteInterviewsByPositionUuid(String positionUuid);
    DeleteResponse deleteInterviewsByPositionUuidAndRecruiterUuid(String positionUuid, String recruiterUuid);
    DeleteResponse deleteInterviewByPositionUuidAndCandidateUuid(String positionUuid, String candidateUuid);
    DeleteResponse deleteInterviewsByCandidateUuidAndRecruiterUuid(String candidateUuid, String recruiterUuid);
    DeleteResponse deleteAllInterviews();
}
