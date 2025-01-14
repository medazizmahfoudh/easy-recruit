package com.easyrecruit.management.service.impl.converter;

import com.easyrecruit.management.dal.entity.CandidateEntity;
import com.easyrecruit.management.infra.model.entity.Candidate;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-14T20:34:48+0100",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.4 (Oracle Corporation)"
)
public class CandidateConverterImpl implements CandidateConverter {

    @Override
    public CandidateEntity toEntity(Candidate Candidate) {
        if ( Candidate == null ) {
            return null;
        }

        CandidateEntity candidateEntity = new CandidateEntity();

        if ( Candidate.getId() != null ) {
            candidateEntity.setId( Long.parseLong( Candidate.getId() ) );
        }
        candidateEntity.setUuid( Candidate.getUuid() );
        candidateEntity.setFirstname( Candidate.getFirstname() );
        candidateEntity.setLastname( Candidate.getLastname() );
        candidateEntity.setEmail( Candidate.getEmail() );

        return candidateEntity;
    }

    @Override
    public Candidate fromEntity(CandidateEntity CandidateEntity) {
        if ( CandidateEntity == null ) {
            return null;
        }

        Candidate candidate = new Candidate();

        if ( CandidateEntity.getId() != null ) {
            candidate.setId( String.valueOf( CandidateEntity.getId() ) );
        }
        candidate.setUuid( CandidateEntity.getUuid() );
        candidate.setFirstname( CandidateEntity.getFirstname() );
        candidate.setLastname( CandidateEntity.getLastname() );
        candidate.setEmail( CandidateEntity.getEmail() );

        return candidate;
    }
}
