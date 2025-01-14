package com.easyrecruit.management.service.impl.converter;

import com.easyrecruit.management.dal.entity.RecruiterEntity;
import com.easyrecruit.management.infra.model.entity.Recruiter;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-05T18:14:10+0100",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
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
        recruiterEntity.setUuid( Recruiter.getUuid() );
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
        recruiter.setUuid( RecruiterEntity.getUuid() );
        recruiter.setFirstname( RecruiterEntity.getFirstname() );
        recruiter.setLastname( RecruiterEntity.getLastname() );
        recruiter.setDepartment( RecruiterEntity.getDepartment() );
        recruiter.setTitle( RecruiterEntity.getTitle() );

        return recruiter;
    }
}
