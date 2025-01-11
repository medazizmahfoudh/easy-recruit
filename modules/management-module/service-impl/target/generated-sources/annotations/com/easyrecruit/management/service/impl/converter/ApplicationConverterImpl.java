package com.easyrecruit.management.service.impl.converter;

import com.easyrecruit.management.dal.entity.ApplicationEntity;
import com.easyrecruit.management.infra.model.Cv;
import com.easyrecruit.management.infra.model.entity.Application;
import com.easyrecruit.management.infra.model.entity.Position;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-11T19:33:19+0100",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
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
        if ( application.getId() != null ) {
            applicationEntity.setId( Long.parseLong( application.getId() ) );
        }
        applicationEntity.setUuid( application.getUuid() );
        applicationEntity.setCandidate( application.getCandidate() );
        applicationEntity.setStatus( application.getStatus() );

        return applicationEntity;
    }

    @Override
    public Application fromEntity(ApplicationEntity applicationEntity) {
        if ( applicationEntity == null ) {
            return null;
        }

        Application application = new Application();

        if ( applicationEntity.getId() != null ) {
            application.setId( String.valueOf( applicationEntity.getId() ) );
        }
        application.setUuid( applicationEntity.getUuid() );
        application.setStatus( applicationEntity.getStatus() );
        application.setCandidate( applicationEntity.getCandidate() );

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
}
