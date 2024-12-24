package com.easyrecruit.core.service.impl.converter;

import com.easyrecruit.core.dal.entity.AppUserRoleEntity;
import com.easyrecruit.core.ws.rest.model.entity.AppUserRole;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AppUserRoleConverter {
    public AppUserRoleConverter INSTANCE = Mappers.getMapper(AppUserRoleConverter.class);
    public AppUserRoleEntity toEntity(AppUserRole u);
    public AppUserRole fromEntity(AppUserRoleEntity u);
}
