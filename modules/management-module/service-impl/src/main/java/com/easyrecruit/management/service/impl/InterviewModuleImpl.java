package com.easyrecruit.management.service.impl;

import com.easyrecruit.management.dal.entity.InterviewEntity;
import com.easyrecruit.management.dal.repository.InterviewRepository;
import com.easyrecruit.management.infra.model.entity.*;
import com.easyrecruit.management.infra.model.payload.request.InterviewCreateOrUpdateRequest;
import com.easyrecruit.management.infra.model.payload.response.DeleteResponse;
import com.easyrecruit.management.service.api.*;
import com.easyrecruit.management.service.api.exception.CRUDOperation;
import com.easyrecruit.management.service.api.exception.CRUDOperationException;
import com.easyrecruit.management.service.impl.converter.InterviewConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class InterviewModuleImpl implements InterviewModule {

    @Autowired
    private InterviewRepository repository;
    @Autowired
    private RecruiterModule recruiterModule;
    @Autowired
    private CandidateModule candidateModule;
    @Autowired
    private PositionModule positionModule;
    @Autowired
    private ApplicationModule applicationModule;
    @Autowired
    private EvaluationModule evaluationModule;

    @Override
    public Interview createInterview(InterviewCreateOrUpdateRequest request) throws CRUDOperationException {



        Recruiter recruiter = recruiterModule.getRecruiterByUuid(request.recruiterUuid());
        Candidate candidate = candidateModule.getCandidateByUuid(request.candidateUuid());
        Position position = positionModule.getPositionByUuid(request.positionUuid());

        Interview interview = new Interview()
                .setDate(Date.valueOf(request.date()))
                .setLocation(request.location())
                .setCandidate(candidate)
                .setRecruiter(recruiter)
                .setPosition(position);

        InterviewEntity interviewEntity = InterviewConverter.INSTANCE.toEntity(interview);
        repository.save(interviewEntity);

        Application application = applicationModule.getApplicationByCandidateUuidAndPositionUuid(candidate.getUuid(), position.getUuid());
        Evaluation evaluation = new Evaluation().setApplicationUuid(application.getUuid())
                .setStep(RecruitmentStep.INTERVIEW);
        evaluationModule.createEvaluation(evaluation);

        return interview;
    }

    @Override
    public Interview updateInterview(InterviewCreateOrUpdateRequest request, String uuid) throws CRUDOperationException {
        Optional<InterviewEntity> interviewEntity = repository.getInterviewEntityByUuid(UUID.fromString(uuid));
        if (interviewEntity.isEmpty()) {
            throw new CRUDOperationException(CRUDOperation.READ, "Interview for the given uuid not found.");
        }

        Interview interview = InterviewConverter.INSTANCE.fromEntity(interviewEntity.get());
        interview.
                setDate(Date.valueOf(request.date()))
                .setLocation(request.location())
                .setCandidate(candidateModule.getCandidateByUuid(request.candidateUuid()))
                .setRecruiter(recruiterModule.getRecruiterByUuid(uuid))
                .setPosition(positionModule.getPositionByUuid(request.positionUuid()));

        repository.save(InterviewConverter.INSTANCE.toEntity(interview));
        return interview;
    }

    @Override
    public Interview getInterviewByUuid(String uuid) {
        Optional<InterviewEntity> interviewEntity = repository.getInterviewEntityByUuid(UUID.fromString(uuid));
        if (interviewEntity.isEmpty()) {
            throw new CRUDOperationException(CRUDOperation.READ, "Interview for the given uuid not found.");
        }
        return InterviewConverter.INSTANCE.fromEntity(interviewEntity.get());
    }

    @Override
    public List<Interview> getAllInterviews() {
        List<InterviewEntity> interviewEntities = repository.findAll();
        return interviewEntities
                .stream()
                .map(InterviewConverter.INSTANCE::fromEntity)
                .map(interview -> interview.setPosition(positionModule.getPositionByUuid(interview.getPosition().getUuid())))
                .toList();
    }

    @Override
    public List<Interview> getInterviewsByCandidateUuid(String candidateUuid) {
        List<InterviewEntity> interviewEntities = repository.getInterviewEntitiesByCandidate_Uuid(UUID.fromString(candidateUuid));
        return interviewEntities
                .stream()
                .map(InterviewConverter.INSTANCE::fromEntity)
                .map(interview -> interview.setPosition(positionModule.getPositionByUuid(interview.getPosition().getUuid())))
                .toList();
    }
    @Override
    public List<Interview> getInterviewsByRecruiterUuid(String recruiterUuid) {
        List<InterviewEntity> interviewEntities = repository.getInterviewEntitiesByRecruiterUuid(UUID.fromString(recruiterUuid));
        return interviewEntities
                .stream()
                .map(InterviewConverter.INSTANCE::fromEntity)
                .map(interview -> interview.setPosition(positionModule.getPositionByUuid(interview.getPosition().getUuid())))
                .toList();
    }

    @Override
    public List<Interview> getInterviewsByPositionUuid(String positionUuid) {
        List<InterviewEntity> interviewEntities = repository.getInterviewEntitiesByPositionUuid(positionUuid);
        return interviewEntities
                .stream()
                .map(InterviewConverter.INSTANCE::fromEntity)
                .map(interview -> interview.setPosition(positionModule.getPositionByUuid(interview.getPosition().getUuid())))
                .toList();
    }

    @Override
    public Interview getInterviewByPositionUuidAndCandidateUuid(String positionUuid, String candidateUuid) {
        Optional<InterviewEntity> interviewEntity = repository.getInterviewEntityByPositionUuidAndCandidate_Uuid(positionUuid, UUID.fromString(candidateUuid));
        if (interviewEntity.isEmpty()) {
            throw new CRUDOperationException(CRUDOperation.READ, "No interviews found for the given position and candidate.");
        }
        Interview interview = InterviewConverter.INSTANCE.fromEntity(interviewEntity.get());
        interview.setPosition(positionModule.getPositionByUuid(interview.getPosition().getUuid()));
        return interview;
    }

    @Override
    public List<Interview> getInterviewsByPositionUuidAndRecruiterUuid(String positionUuid, String recruiterUuid) {
        List<InterviewEntity> interviewEntities = repository.getInterviewEntitiesByPositionUuidAndRecruiterUuid(positionUuid, UUID.fromString(recruiterUuid));
        return interviewEntities
                .stream()
                .map(InterviewConverter.INSTANCE::fromEntity)
                .map(interview -> interview.setPosition(positionModule.getPositionByUuid(interview.getPosition().getUuid())))
                .toList();
    }

    @Override
    public List<Interview> getInterviewsByCandidateUuidAndRecruiterUuid(String candidateUuid, String recruiterUuid) {
        List<InterviewEntity> interviewEntities = repository.getInterviewEntitiesByCandidate_UuidAndRecruiterUuid(UUID.fromString(candidateUuid), UUID.fromString(recruiterUuid));
        return interviewEntities
                .stream()
                .map(InterviewConverter.INSTANCE::fromEntity)
                .map(interview -> interview.setPosition(positionModule.getPositionByUuid(interview.getPosition().getUuid())))
                .toList();
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
