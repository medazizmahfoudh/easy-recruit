package com.easyrecruit.interview.impl.converter;

import com.easyrecruit.interview.dal.entity.ResponseEntity;
import com.easyrecruit.interview.infra.Entity.Response;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface ReponseConverter {
    ReponseConverter INSTANCE = Mappers.getMapper(ReponseConverter.class);
    ResponseEntity toEntity (Response response);
    Response fromEntity (ResponseEntity responseEntity);
}
