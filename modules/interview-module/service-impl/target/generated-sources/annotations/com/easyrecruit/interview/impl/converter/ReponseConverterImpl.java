package com.easyrecruit.interview.impl.converter;

import com.easyrecruit.interview.dal.entity.ResponseEntity;
import com.easyrecruit.interview.infra.Entity.Response;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-14T10:28:07+0100",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.11 (Amazon.com Inc.)"
)
public class ReponseConverterImpl implements ReponseConverter {

    @Override
    public ResponseEntity toEntity(Response response) {
        if ( response == null ) {
            return null;
        }

        ResponseEntity responseEntity = new ResponseEntity();

        return responseEntity;
    }

    @Override
    public Response fromEntity(ResponseEntity responseEntity) {
        if ( responseEntity == null ) {
            return null;
        }

        Response response = new Response();

        return response;
    }
}
