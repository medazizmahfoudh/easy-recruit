package com.easyrecruit.core.service.impl.converter;

import com.easyrecruit.core.dal.entity.AppUserEntity;
import com.easyrecruit.core.ws.rest.model.entity.AppUser;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AppUserConverter {
     AppUserConverter INSTANCE = Mappers.getMapper(AppUserConverter.class);
     AppUserEntity toEntity(AppUser u);
     AppUser fromEntity(AppUserEntity u);
     static AppUser fromEntityNoPassword(AppUserEntity u){
        AppUser e = INSTANCE.fromEntity(u);
        if(e!=null){
            e.setPassword(null);
        }
        return e;
    }
}
