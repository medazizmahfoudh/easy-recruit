package com.easyrecruit.interview.impl.converter;

import com.easyrecruit.interview.dal.entity.ReponseEntity;
import com.easyrecruit.interview.infra.Entity.Reponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface ReponseConverter {
    ReponseConverter INSTANCE = Mappers.getMapper(ReponseConverter.class);
    ReponseEntity toEntity (Reponse reponse);
    Reponse fromEntity (ReponseEntity reponseEntity);
}
