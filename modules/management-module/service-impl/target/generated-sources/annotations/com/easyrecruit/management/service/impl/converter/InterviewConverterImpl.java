package com.easyrecruit.management.service.impl.converter;

import com.easyrecruit.management.dal.entity.CandidateEntity;
import com.easyrecruit.management.dal.entity.EvaluationEntity;
import com.easyrecruit.management.dal.entity.InterviewEntity;
import com.easyrecruit.management.dal.entity.RecruiterEntity;
import com.easyrecruit.management.infra.model.entity.Candidate;
import com.easyrecruit.management.infra.model.entity.Evaluation;
import com.easyrecruit.management.infra.model.entity.Interview;
import com.easyrecruit.management.infra.model.entity.Position;
import com.easyrecruit.management.infra.model.entity.Recruiter;
import java.util.UUID;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-14T15:51:14+0100",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.13 (Ubuntu)"
)
public class InterviewConverterImpl implements InterviewConverter {

    @Override
    public InterviewEntity toEntity(Interview Interview) {
        if ( Interview == null ) {
            return null;
        }

        InterviewEntity interviewEntity = new InterviewEntity();

        interviewEntity.setPositionUuid( interviewPositionUuid( Interview ) );
        if ( Interview.getId() != null ) {
            interviewEntity.setId( Long.parseLong( Interview.getId() ) );
        }
        if ( Interview.getUuid() != null ) {
            interviewEntity.setUuid( UUID.fromString( Interview.getUuid() ) );
        }
        interviewEntity.setDate( Interview.getDate() );
        interviewEntity.setLocation( Interview.getLocation() );
        interviewEntity.setRecruiter( recruiterToRecruiterEntity( Interview.getRecruiter() ) );
        interviewEntity.setCandidate( candidateToCandidateEntity( Interview.getCandidate() ) );
        interviewEntity.setEvaluation( evaluationToEvaluationEntity( Interview.getEvaluation() ) );

        return interviewEntity;
    }

    @Override
    public Interview fromEntity(InterviewEntity InterviewEntity) {
        if ( InterviewEntity == null ) {
            return null;
        }

        Interview interview = new Interview();

        interview.setPosition( interviewEntityToPosition( InterviewEntity ) );
        if ( InterviewEntity.getId() != null ) {
            interview.setId( String.valueOf( InterviewEntity.getId() ) );
        }
        if ( InterviewEntity.getUuid() != null ) {
            interview.setUuid( InterviewEntity.getUuid().toString() );
        }
        interview.setDate( InterviewEntity.getDate() );
        interview.setLocation( InterviewEntity.getLocation() );
        interview.setEvaluation( evaluationEntityToEvaluation( InterviewEntity.getEvaluation() ) );
        interview.setRecruiter( recruiterEntityToRecruiter( InterviewEntity.getRecruiter() ) );
        interview.setCandidate( candidateEntityToCandidate( InterviewEntity.getCandidate() ) );

        return interview;
    }

    private String interviewPositionUuid(Interview interview) {
        Position position = interview.getPosition();
        if ( position == null ) {
            return null;
        }
        return position.getUuid();
    }

    protected RecruiterEntity recruiterToRecruiterEntity(Recruiter recruiter) {
        if ( recruiter == null ) {
            return null;
        }

        RecruiterEntity recruiterEntity = new RecruiterEntity();

        if ( recruiter.getId() != null ) {
            recruiterEntity.setId( Long.parseLong( recruiter.getId() ) );
        }
        if ( recruiter.getUuid() != null ) {
            recruiterEntity.setUuid( UUID.fromString( recruiter.getUuid() ) );
        }
        recruiterEntity.setFirstname( recruiter.getFirstname() );
        recruiterEntity.setLastname( recruiter.getLastname() );
        recruiterEntity.setDepartment( recruiter.getDepartment() );
        recruiterEntity.setTitle( recruiter.getTitle() );

        return recruiterEntity;
    }

    protected CandidateEntity candidateToCandidateEntity(Candidate candidate) {
        if ( candidate == null ) {
            return null;
        }

        CandidateEntity candidateEntity = new CandidateEntity();

        if ( candidate.getId() != null ) {
            candidateEntity.setId( Long.parseLong( candidate.getId() ) );
        }
        if ( candidate.getUuid() != null ) {
            candidateEntity.setUuid( UUID.fromString( candidate.getUuid() ) );
        }
        candidateEntity.setFirstname( candidate.getFirstname() );
        candidateEntity.setLastname( candidate.getLastname() );
        candidateEntity.setEmail( candidate.getEmail() );

        return candidateEntity;
    }

    protected EvaluationEntity evaluationToEvaluationEntity(Evaluation evaluation) {
        if ( evaluation == null ) {
            return null;
        }

        EvaluationEntity evaluationEntity = new EvaluationEntity();

        evaluationEntity.setId( evaluation.getId() );
        if ( evaluation.getUuid() != null ) {
            evaluationEntity.setUuid( UUID.fromString( evaluation.getUuid() ) );
        }
        evaluationEntity.setApplicationUuid( evaluation.getApplicationUuid() );
        evaluationEntity.setStep( evaluation.getStep() );
        evaluationEntity.setScore( evaluation.getScore() );
        evaluationEntity.setFeedback( evaluation.getFeedback() );
        evaluationEntity.setDecision( evaluation.getDecision() );
        evaluationEntity.setStatus( evaluation.getStatus() );

        return evaluationEntity;
    }

    protected Position interviewEntityToPosition(InterviewEntity interviewEntity) {
        if ( interviewEntity == null ) {
            return null;
        }

        Position position = new Position();

        position.setUuid( interviewEntity.getPositionUuid() );

        return position;
    }

    protected Evaluation evaluationEntityToEvaluation(EvaluationEntity evaluationEntity) {
        if ( evaluationEntity == null ) {
            return null;
        }

        Evaluation evaluation = new Evaluation();

        evaluation.setId( evaluationEntity.getId() );
        if ( evaluationEntity.getUuid() != null ) {
            evaluation.setUuid( evaluationEntity.getUuid().toString() );
        }
        evaluation.setApplicationUuid( evaluationEntity.getApplicationUuid() );
        evaluation.setStep( evaluationEntity.getStep() );
        evaluation.setScore( evaluationEntity.getScore() );
        evaluation.setDecision( evaluationEntity.getDecision() );
        evaluation.setFeedback( evaluationEntity.getFeedback() );
        evaluation.setStatus( evaluationEntity.getStatus() );

        return evaluation;
    }

    protected Recruiter recruiterEntityToRecruiter(RecruiterEntity recruiterEntity) {
        if ( recruiterEntity == null ) {
            return null;
        }

        Recruiter recruiter = new Recruiter();

        if ( recruiterEntity.getId() != null ) {
            recruiter.setId( String.valueOf( recruiterEntity.getId() ) );
        }
        if ( recruiterEntity.getUuid() != null ) {
            recruiter.setUuid( recruiterEntity.getUuid().toString() );
        }
        recruiter.setFirstname( recruiterEntity.getFirstname() );
        recruiter.setLastname( recruiterEntity.getLastname() );
        recruiter.setDepartment( recruiterEntity.getDepartment() );
        recruiter.setTitle( recruiterEntity.getTitle() );

        return recruiter;
    }

    protected Candidate candidateEntityToCandidate(CandidateEntity candidateEntity) {
        if ( candidateEntity == null ) {
            return null;
        }

        Candidate candidate = new Candidate();

        if ( candidateEntity.getId() != null ) {
            candidate.setId( String.valueOf( candidateEntity.getId() ) );
        }
        if ( candidateEntity.getUuid() != null ) {
            candidate.setUuid( candidateEntity.getUuid().toString() );
        }
        candidate.setFirstname( candidateEntity.getFirstname() );
        candidate.setLastname( candidateEntity.getLastname() );
        candidate.setEmail( candidateEntity.getEmail() );

        return candidate;
    }
}
