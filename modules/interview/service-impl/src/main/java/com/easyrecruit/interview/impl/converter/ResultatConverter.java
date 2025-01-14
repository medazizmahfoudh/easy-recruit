package com.easyrecruit.interview.impl.converter;

import com.easyrecruit.interview.dal.entity.ResultatEntity;
import com.easyrecruit.interview.infra.Entity.Resultat;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface ResultatConverter {
   ResultatConverter INSTANCE = Mappers.getMapper(ResultatConverter.class);
    ResultatEntity toEntity (Resultat resultat);
    Resultat fromEntity (ResultatEntity resultatEntity);
}
