package com.easyrecruit.management.service.impl.converter;

import com.easyrecruit.management.dal.document.CvDocument;
import com.easyrecruit.management.infra.model.Cv;
import com.easyrecruit.management.infra.model.entity.Skill;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-14T13:59:09+0100",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.13 (Ubuntu)"
)
public class CvConverterImpl implements CvConverter {

    @Override
    public CvDocument toEntity(Cv cv) {
        if ( cv == null ) {
            return null;
        }

        CvDocument cvDocument = new CvDocument();

        cvDocument.setUuid( cv.getUuid() );
        cvDocument.setApplicationUuid( cv.getApplicationUuid() );
        cvDocument.setDocument( cv.getDocument() );
        List<Skill> list = cv.getSkills();
        if ( list != null ) {
            cvDocument.setSkills( new ArrayList<Skill>( list ) );
        }

        return cvDocument;
    }

    @Override
    public Cv fromEntity(CvDocument cvDocument) {
        if ( cvDocument == null ) {
            return null;
        }

        Cv cv = new Cv();

        cv.setUuid( cvDocument.getUuid() );
        cv.setApplicationUuid( cvDocument.getApplicationUuid() );
        cv.setDocument( cvDocument.getDocument() );
        List<Skill> list = cvDocument.getSkills();
        if ( list != null ) {
            cv.setSkills( new ArrayList<Skill>( list ) );
        }

        return cv;
    }
}
