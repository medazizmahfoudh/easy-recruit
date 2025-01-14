package com.easyrecruit.interview.impl.converter;

import com.easyrecruit.interview.dal.entity.ReponseEntity;
import com.easyrecruit.interview.infra.Entity.Reponse;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-14T10:28:07+0100",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.11 (Amazon.com Inc.)"
)
public class ReponseConverterImpl implements ReponseConverter {

    @Override
    public ReponseEntity toEntity(Reponse reponse) {
        if ( reponse == null ) {
            return null;
        }

        ReponseEntity reponseEntity = new ReponseEntity();

        return reponseEntity;
    }

    @Override
    public Reponse fromEntity(ReponseEntity reponseEntity) {
        if ( reponseEntity == null ) {
            return null;
        }

        Reponse reponse = new Reponse();

        return reponse;
    }
}
