package com.easyrecruit.interview.impl.converter;

import com.easyrecruit.interview.dal.entity.ResponseUserEntity;
import com.easyrecruit.interview.infra.Entity.ResponseUser;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface ResponseUserConverter {
    ResponseUserConverter INSTANCE = Mappers.getMapper(ResponseUserConverter.class);
    ResponseUserEntity toEntity(ResponseUser responseUser);
    ResponseUser fromEntity(ResponseUserEntity responseUserEntity);
}
