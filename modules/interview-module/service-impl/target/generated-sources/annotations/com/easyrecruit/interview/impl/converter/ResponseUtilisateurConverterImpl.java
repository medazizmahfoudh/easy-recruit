package com.easyrecruit.interview.impl.converter;

import com.easyrecruit.interview.dal.entity.ResponseUserEntity;
import com.easyrecruit.interview.infra.Entity.ResponseUser;

import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-14T10:28:07+0100",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.11 (Amazon.com Inc.)"
)
public class ResponseUtilisateurConverterImpl implements ResponseUtilisateurConverter {

    @Override
    public ResponseUserEntity toEntity(ResponseUser responseUser) {
        if ( responseUser == null ) {
            return null;
        }

        ResponseUserEntity responseUserEntity = new ResponseUserEntity();

        responseUserEntity.setId( responseUser.getId() );
        responseUserEntity.setCandidate( responseUser.getCandidate() );
        responseUserEntity.setQuestion( responseUser.getQuestion() );
        responseUserEntity.setResponse( responseUser.getResponse() );
        responseUserEntity.setCorrect( responseUser.isCorrect() );

        return responseUserEntity;
    }

    @Override
    public ResponseUser fromEntity(ResponseUserEntity responseUserEntity) {
        if ( responseUserEntity == null ) {
            return null;
        }

        ResponseUser responseUser = new ResponseUser();

        responseUser.setId( responseUserEntity.getId() );
        responseUser.setQuestion( responseUserEntity.getQuestion() );
        responseUser.setResponse( responseUserEntity.getResponse() );
        responseUser.setCorrect( responseUserEntity.isCorrect() );

        return responseUser;
    }
}
