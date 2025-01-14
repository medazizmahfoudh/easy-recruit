package com.easyrecruit.interview.impl.converter;

import com.easyrecruit.interview.dal.entity.ResultatEntity;
import com.easyrecruit.interview.infra.Entity.Resultat;
import com.easyrecruit.management.dal.entity.CandidateEntity;
import com.easyrecruit.management.infra.model.entity.Candidate;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-14T10:28:07+0100",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.11 (Amazon.com Inc.)"
)
public class ResultatConverterImpl implements ResultatConverter {

    @Override
    public ResultatEntity toEntity(Resultat resultat) {
        if ( resultat == null ) {
            return null;
        }

        ResultatEntity resultatEntity = new ResultatEntity();

        resultatEntity.setId( resultat.getId() );
        resultatEntity.setCandidate( candidateToCandidateEntity( resultat.getCandidate() ) );
        resultatEntity.setScore( resultat.getScore() );
        resultatEntity.setTopic( resultat.getTopic() );

        return resultatEntity;
    }

    @Override
    public Resultat fromEntity(ResultatEntity resultatEntity) {
        if ( resultatEntity == null ) {
            return null;
        }

        Resultat resultat = new Resultat();

        resultat.setId( resultatEntity.getId() );
        resultat.setCandidate( candidateEntityToCandidate( resultatEntity.getCandidate() ) );
        resultat.setScore( resultatEntity.getScore() );
        resultat.setTopic( resultatEntity.getTopic() );

        return resultat;
    }

    protected CandidateEntity candidateToCandidateEntity(Candidate candidate) {
        if ( candidate == null ) {
            return null;
        }

        CandidateEntity candidateEntity = new CandidateEntity();

        if ( candidate.getId() != null ) {
            candidateEntity.setId( Long.parseLong( candidate.getId() ) );
        }
        candidateEntity.setUuid( candidate.getUuid() );
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

        if ( candidateEntity.getId() != null ) {
            candidate.setId( String.valueOf( candidateEntity.getId() ) );
        }
        candidate.setUuid( candidateEntity.getUuid() );
        candidate.setFirstname( candidateEntity.getFirstname() );
        candidate.setLastname( candidateEntity.getLastname() );
        candidate.setEmail( candidateEntity.getEmail() );

        return candidate;
    }
}
