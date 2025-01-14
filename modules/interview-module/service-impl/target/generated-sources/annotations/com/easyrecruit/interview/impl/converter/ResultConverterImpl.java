package com.easyrecruit.interview.impl.converter;

import com.easyrecruit.interview.dal.entity.ResultEntity;
import com.easyrecruit.interview.infra.Entity.Result;
import com.easyrecruit.management.dal.entity.CandidateEntity;
import com.easyrecruit.management.infra.model.entity.Candidate;
import java.util.UUID;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-14T21:30:38+0100",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.11 (Amazon.com Inc.)"
)
public class ResultConverterImpl implements ResultConverter {

    @Override
    public ResultEntity toEntity(Result result) {
        if ( result == null ) {
            return null;
        }

        ResultEntity resultEntity = new ResultEntity();

        resultEntity.setId( result.getId() );
        resultEntity.setCandidate( candidateToCandidateEntity( result.getCandidate() ) );
        resultEntity.setScore( result.getScore() );
        resultEntity.setTopic( result.getTopic() );
        resultEntity.setTotalQuestions( result.getTotalQuestions() );
        resultEntity.setCorrectQuestions( result.getCorrectQuestions() );

        return resultEntity;
    }

    @Override
    public Result fromEntity(ResultEntity resultEntity) {
        if ( resultEntity == null ) {
            return null;
        }

        Result result = new Result();

        result.setId( resultEntity.getId() );
        result.setCandidate( candidateEntityToCandidate( resultEntity.getCandidate() ) );
        result.setScore( resultEntity.getScore() );
        result.setTopic( resultEntity.getTopic() );
        result.setTotalQuestions( resultEntity.getTotalQuestions() );
        result.setCorrectQuestions( resultEntity.getCorrectQuestions() );

        return result;
    }

    protected CandidateEntity candidateToCandidateEntity(Candidate candidate) {
        if ( candidate == null ) {
            return null;
        }

        CandidateEntity candidateEntity = new CandidateEntity();

        candidateEntity.setId( candidate.getId() );
        if ( candidate.getUuid() != null ) {
            candidateEntity.setUuid( UUID.fromString( candidate.getUuid() ) );
        }
        candidateEntity.setFirstname( candidate.getFirstname() );
        candidateEntity.setLastname( candidate.getLastname() );
        candidateEntity.setEmail( candidate.getEmail() );

        return candidateEntity;
    }

    protected Candidate candidateEntityToCandidate(CandidateEntity candidateEntity) {
        if ( candidateEntity == null ) {
            return null;
        }

        Candidate candidate = new Candidate();

        candidate.setId( candidateEntity.getId() );
        if ( candidateEntity.getUuid() != null ) {
            candidate.setUuid( candidateEntity.getUuid().toString() );
        }
        candidate.setFirstname( candidateEntity.getFirstname() );
        candidate.setLastname( candidateEntity.getLastname() );
        candidate.setEmail( candidateEntity.getEmail() );

        return candidate;
    }
}
