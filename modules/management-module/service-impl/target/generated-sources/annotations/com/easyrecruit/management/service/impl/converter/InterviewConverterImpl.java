package com.easyrecruit.management.service.impl.converter;

import com.easyrecruit.management.dal.entity.InterviewEntity;
import com.easyrecruit.management.infra.model.entity.Interview;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-05T23:10:20+0100",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.11 (Amazon.com Inc.)"
)
public class InterviewConverterImpl implements InterviewConverter {

    @Override
    public InterviewEntity toEntity(Interview Interview) {
        if ( Interview == null ) {
            return null;
        }

        InterviewEntity interviewEntity = new InterviewEntity();

        if ( Interview.getId() != null ) {
            interviewEntity.setId( Long.parseLong( Interview.getId() ) );
        }
        interviewEntity.setUuid( Interview.getUuid() );
        interviewEntity.setDate( Interview.getDate() );
        interviewEntity.setLocation( Interview.getLocation() );
        interviewEntity.setPositionUuid( Interview.getPositionUuid() );
        interviewEntity.setRecruiter( Interview.getRecruiter() );
        interviewEntity.setCandidate( Interview.getCandidate() );

        return interviewEntity;
    }

    @Override
    public Interview fromEntity(InterviewEntity InterviewEntity) {
        if ( InterviewEntity == null ) {
            return null;
        }

        Interview interview = new Interview();

        if ( InterviewEntity.getId() != null ) {
            interview.setId( String.valueOf( InterviewEntity.getId() ) );
        }
        interview.setUuid( InterviewEntity.getUuid() );
        interview.setDate( InterviewEntity.getDate() );
        interview.setLocation( InterviewEntity.getLocation() );
        interview.setPositionUuid( InterviewEntity.getPositionUuid() );
        interview.setRecruiter( InterviewEntity.getRecruiter() );
        interview.setCandidate( InterviewEntity.getCandidate() );

        return interview;
    }
}
