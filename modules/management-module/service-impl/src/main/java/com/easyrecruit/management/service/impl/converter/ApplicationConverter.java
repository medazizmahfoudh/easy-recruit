package com.easyrecruit.management.service.impl.converter;

import com.easyrecruit.management.dal.entity.ApplicationEntity;
import com.easyrecruit.management.infra.model.entity.Application;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ApplicationConverter {
    ApplicationConverter INSTANCE = Mappers.getMapper(ApplicationConverter.class);
    @Mapping(source = "cv.uuid", target = "cvUuid")
    @Mapping(source = "position.uuid", target = "positionUuid")
    ApplicationEntity toEntity(Application application);
    Application fromEntity(ApplicationEntity applicationEntity);

}
