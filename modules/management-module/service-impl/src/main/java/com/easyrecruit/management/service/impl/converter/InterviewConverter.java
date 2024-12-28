package com.easyrecruit.management.service.impl.converter;

import com.easyrecruit.management.dal.entity.InterviewEntity;
import com.easyrecruit.management.infra.model.entity.Interview;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface InterviewConverter {
    InterviewConverter INSTANCE = Mappers.getMapper(InterviewConverter.class);
    InterviewEntity toEntity(Interview Interview);
    Interview fromEntity(InterviewEntity InterviewEntity);
}
