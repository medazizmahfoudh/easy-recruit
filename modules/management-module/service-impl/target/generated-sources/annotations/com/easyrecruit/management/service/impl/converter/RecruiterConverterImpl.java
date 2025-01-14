package com.easyrecruit.management.service.impl.converter;

import com.easyrecruit.management.dal.entity.RecruiterEntity;
import com.easyrecruit.management.infra.model.entity.Recruiter;
import java.util.UUID;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-14T16:15:40+0100",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.13 (Ubuntu)"
)
public class RecruiterConverterImpl implements RecruiterConverter {

    @Override
    public RecruiterEntity toEntity(Recruiter Recruiter) {
        if ( Recruiter == null ) {
            return null;
        }

        RecruiterEntity recruiterEntity = new RecruiterEntity();

        if ( Recruiter.getId() != null ) {
            recruiterEntity.setId( Long.parseLong( Recruiter.getId() ) );
        }
        if ( Recruiter.getUuid() != null ) {
            recruiterEntity.setUuid( UUID.fromString( Recruiter.getUuid() ) );
        }
        recruiterEntity.setFirstname( Recruiter.getFirstname() );
        recruiterEntity.setLastname( Recruiter.getLastname() );
        recruiterEntity.setDepartment( Recruiter.getDepartment() );
        recruiterEntity.setTitle( Recruiter.getTitle() );

        return recruiterEntity;
    }

    @Override
    public Recruiter fromEntity(RecruiterEntity RecruiterEntity) {
        if ( RecruiterEntity == null ) {
            return null;
        }

        Recruiter recruiter = new Recruiter();

        if ( RecruiterEntity.getId() != null ) {
            recruiter.setId( String.valueOf( RecruiterEntity.getId() ) );
        }
        if ( RecruiterEntity.getUuid() != null ) {
            recruiter.setUuid( RecruiterEntity.getUuid().toString() );
        }
        recruiter.setFirstname( RecruiterEntity.getFirstname() );
        recruiter.setLastname( RecruiterEntity.getLastname() );
        recruiter.setDepartment( RecruiterEntity.getDepartment() );
        recruiter.setTitle( RecruiterEntity.getTitle() );

        return recruiter;
    }
}
