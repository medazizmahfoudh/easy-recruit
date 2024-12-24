package com.easyrecruit.core.service.impl.converter;

import com.easyrecruit.core.dal.entity.AppLogEntity;
import com.easyrecruit.core.ws.rest.model.entity.AppLog;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AppLogConverter {
    public AppLogConverter INSTANCE = Mappers.getMapper(AppLogConverter.class);
    public AppLogEntity toEntity(AppLog u);
    public AppLog fromEntity(AppLogEntity u);
}
