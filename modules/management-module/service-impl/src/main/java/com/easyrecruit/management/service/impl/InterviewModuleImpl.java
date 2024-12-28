package com.easyrecruit.management.service.impl;

import com.easyrecruit.management.dal.entity.InterviewEntity;
import com.easyrecruit.management.dal.repository.InterviewRepository;
import com.easyrecruit.management.infra.model.entity.Candidate;
import com.easyrecruit.management.infra.model.entity.Interview;
import com.easyrecruit.management.infra.model.entity.Recruiter;
import com.easyrecruit.management.infra.model.payload.request.InterviewCreateOrUpdateRequest;
import com.easyrecruit.management.infra.model.payload.response.DeleteResponse;
import com.easyrecruit.management.service.api.CandidateModule;
import com.easyrecruit.management.service.api.InterviewModule;
import com.easyrecruit.management.service.api.RecruiterModule;
import com.easyrecruit.management.service.api.exception.CRUDOperationException;
import com.easyrecruit.management.service.impl.converter.InterviewConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class InterviewModuleImpl implements InterviewModule {

    @Autowired
    private InterviewRepository repository;
    @Autowired
    private RecruiterModule recruiterModule;
    @Autowired
    private CandidateModule candidateModule;

    @Override
    public Interview createInterview(InterviewCreateOrUpdateRequest request) throws CRUDOperationException {

        Recruiter recruiter = recruiterModule.getRecruiterByUuid(request.recruiterUuid());
        Candidate candidate = candidateModule.getCandidateByUuid(request.candidateUuid());
        Interview interview = new Interview()
                .setDate(Date.valueOf(request.date()))
                .setLocation(request.location())
                .setCandidate(candidate)
                .setRecruiter(recruiter)
                .setPositionUuid(request.positionUuid());

        InterviewEntity interviewEntity = InterviewConverter.INSTANCE.toEntity(interview);
        repository.save(interviewEntity);

        return interview;
    }

    @Override
    public Interview updateInterview(InterviewCreateOrUpdateRequest request, String uuid) throws CRUDOperationException {
        return null;
    }

    @Override
    public Interview getInterviewByUuid(String uuid) {
        return null;
    }

    @Override
    public List<Interview> getAllInterviews() {
        return List.of();
    }

    @Override
    public List<Interview> getInterviewsByCandidateUuid(String candidateUuid) {
        return List.of();
    }

    @Override
    public List<Interview> getInterviewsByRecruiterUuid(String recruiterUuid) {
        return List.of();
    }

    @Override
    public List<Interview> getInterviewsByPositionUuid(String positionUuid) {
        return List.of();
    }

    @Override
    public Interview getInterviewByPositionUuidAndCandidateUuid(String positionUuid, String candidateUuid) {
        return null;
    }

    @Override
    public List<Interview> getInterviewsByPositionUuidAndRecruiterUuid(String positionUuid, String recruiterUuid) {
        return List.of();
    }

    @Override
    public List<Interview> getInterviewsByCandidateUuidAndRecruiterUuid(String candidateUuid, String recruiterUuid) {
        return List.of();
    }

    @Override
    public DeleteResponse deleteInterviewByUuid(String Uuid) {
        return null;
    }

    @Override
    public DeleteResponse deleteInterviewsByCandidateUuid(String candidateUuid) {
        return null;
    }

    @Override
    public DeleteResponse deleteInterviewsByRecruiterUuid(String recruiterUuid) {
        return null;
    }

    @Override
    public DeleteResponse deleteInterviewsByPositionUuid(String positionUuid) {
        return null;
    }

    @Override
    public DeleteResponse deleteInterviewsByPositionUuidAndRecruiterUuid(String positionUuid, String recruiterUuid) {
        return null;
    }

    @Override
    public DeleteResponse deleteInterviewByPositionUuidAndCandidateUuid(String positionUuid, String candidateUuid) {
        return null;
    }

    @Override
    public DeleteResponse deleteInterviewsByCandidateUuidAndRecruiterUuid(String candidateUuid, String recruiterUuid) {
        return null;
    }

    @Override
    public DeleteResponse deleteAllInterviews() {
        return null;
    }


}
