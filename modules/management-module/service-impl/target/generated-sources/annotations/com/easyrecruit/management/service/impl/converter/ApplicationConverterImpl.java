package com.easyrecruit.management.service.impl.converter;

import com.easyrecruit.management.dal.entity.ApplicationEntity;
import com.easyrecruit.management.dal.entity.CandidateEntity;
import com.easyrecruit.management.infra.model.Cv;
import com.easyrecruit.management.infra.model.entity.Application;
import com.easyrecruit.management.infra.model.entity.Candidate;
import com.easyrecruit.management.infra.model.entity.Position;
import java.util.UUID;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-14T21:44:34+0100",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.13 (Ubuntu)"
)
public class ApplicationConverterImpl implements ApplicationConverter {

    @Override
    public ApplicationEntity toEntity(Application application) {
        if ( application == null ) {
            return null;
        }

        ApplicationEntity applicationEntity = new ApplicationEntity();

        applicationEntity.setCvUuid( applicationCvUuid( application ) );
        applicationEntity.setPositionUuid( applicationPositionUuid( application ) );
        applicationEntity.setId( application.getId() );
        if ( application.getUuid() != null ) {
            applicationEntity.setUuid( UUID.fromString( application.getUuid() ) );
        }
        applicationEntity.setCandidate( candidateToCandidateEntity( application.getCandidate() ) );
        applicationEntity.setStatus( application.getStatus() );

        return applicationEntity;
    }

    @Override
    public Application fromEntity(ApplicationEntity applicationEntity) {
        if ( applicationEntity == null ) {
            return null;
        }

        Application application = new Application();

        application.setPosition( applicationEntityToPosition( applicationEntity ) );
        application.setId( applicationEntity.getId() );
        if ( applicationEntity.getUuid() != null ) {
            application.setUuid( applicationEntity.getUuid().toString() );
        }
        application.setStatus( applicationEntity.getStatus() );
        application.setCandidate( candidateEntityToCandidate( applicationEntity.getCandidate() ) );

        return application;
    }

    private String applicationCvUuid(Application application) {
        Cv cv = application.getCv();
        if ( cv == null ) {
            return null;
        }
        return cv.getUuid();
    }

    private String applicationPositionUuid(Application application) {
        Position position = application.getPosition();
        if ( position == null ) {
            return null;
        }
        return position.getUuid();
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

    protected Position applicationEntityToPosition(ApplicationEntity applicationEntity) {
        if ( applicationEntity == null ) {
            return null;
        }

        Position position = new Position();

        position.setUuid( applicationEntity.getPositionUuid() );

        return position;
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
