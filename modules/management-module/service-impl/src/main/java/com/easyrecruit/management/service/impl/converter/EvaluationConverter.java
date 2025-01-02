package com.easyrecruit.management.service.impl.converter;

import com.easyrecruit.management.dal.entity.EvaluationEntity;
import com.easyrecruit.management.infra.model.entity.Evaluation;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EvaluationConverter {
    EvaluationConverter INSTANCE = Mappers.getMapper(EvaluationConverter.class);
    EvaluationEntity toEntity(Evaluation evaluation);
    Evaluation fromEntity(EvaluationEntity evaluationEntity);
}
