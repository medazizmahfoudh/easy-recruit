package com.easyrecruit.management.service.impl.converter;

import com.easyrecruit.management.dal.entity.CandidateEntity;
import com.easyrecruit.management.infra.model.entity.Candidate;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CandidateConverter {
    CandidateConverter INSTANCE = Mappers.getMapper(CandidateConverter.class);
    CandidateEntity toEntity(Candidate Candidate);
    Candidate fromEntity(CandidateEntity CandidateEntity);
    Candidate toModel(CandidateEntity candidateEntity);

}
