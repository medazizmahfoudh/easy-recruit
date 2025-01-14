package com.easyrecruit.interview.impl.converter;

import com.easyrecruit.interview.dal.entity.ResultEntity;
import com.easyrecruit.interview.infra.Entity.Result;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface ResultConverter {
   ResultConverter INSTANCE = Mappers.getMapper(ResultConverter.class);
    ResultEntity toEntity (Result result);
    Result fromEntity (ResultEntity resultEntity);
}
