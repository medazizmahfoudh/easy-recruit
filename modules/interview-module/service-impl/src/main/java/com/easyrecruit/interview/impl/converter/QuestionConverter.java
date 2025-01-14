package com.easyrecruit.interview.impl.converter;

import com.easyrecruit.interview.dal.entity.QuestionEntity;
import com.easyrecruit.interview.infra.Entity.Question;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface QuestionConverter {
    QuestionConverter INSTANCE = Mappers.getMapper(QuestionConverter.class);
    QuestionEntity toEntity (Question question);
    Question fromEntity (QuestionEntity questionEntity);
}
