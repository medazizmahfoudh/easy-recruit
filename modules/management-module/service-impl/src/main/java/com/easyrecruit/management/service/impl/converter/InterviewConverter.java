package com.easyrecruit.management.service.impl.converter;

import com.easyrecruit.management.dal.entity.InterviewEntity;
import com.easyrecruit.management.infra.model.entity.Interview;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface InterviewConverter {
    InterviewConverter INSTANCE = Mappers.getMapper(InterviewConverter.class);
    @Mapping(source = "position.uuid", target = "positionUuid")
    InterviewEntity toEntity(Interview Interview);
    @Mapping(source = "positionUuid", target = "position.uuid")
    Interview fromEntity(InterviewEntity InterviewEntity);
}
