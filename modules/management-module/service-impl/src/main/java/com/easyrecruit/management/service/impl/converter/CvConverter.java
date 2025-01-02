package com.easyrecruit.management.service.impl.converter;

import com.easyrecruit.management.dal.document.CvDocument;
import com.easyrecruit.management.infra.model.document.Cv;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CvConverter {
    CvConverter INSTANCE = Mappers.getMapper(CvConverter.class);
    CvDocument toEntity(Cv cv);
    Cv fromEntity(CvDocument cvDocument);
}
