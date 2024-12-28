package com.easyrecruit.management.service.impl.converter;

import com.easyrecruit.management.dal.entity.RecruiterEntity;
import com.easyrecruit.management.infra.model.entity.Recruiter;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RecruiterConverter {
    RecruiterConverter INSTANCE = Mappers.getMapper(RecruiterConverter.class);
    RecruiterEntity toEntity(Recruiter Recruiter);
    Recruiter fromEntity(RecruiterEntity RecruiterEntity);
}
