package com.easyrecruit.interview.impl.converter;

import com.easyrecruit.interview.dal.entity.ResultEntity;
import com.easyrecruit.interview.infra.Entity.Result;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface ResultatConverter {
   ResultatConverter INSTANCE = Mappers.getMapper(ResultatConverter.class);
    ResultEntity toEntity (Result result);
    Result fromEntity (ResultEntity resultEntity);
}
