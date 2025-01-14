package com.easyrecruit.interview.impl.converter;

import com.easyrecruit.interview.dal.entity.ReponseUtilisateurEntity;
import com.easyrecruit.interview.infra.Entity.ReponseUtilisateur;
import com.easyrecruit.management.dal.entity.CandidateEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface ResponseUtilisateurConverter {
    ResponseUtilisateurConverter INSTANCE = Mappers.getMapper(ResponseUtilisateurConverter.class);
    ReponseUtilisateurEntity toEntity(ReponseUtilisateur reponseUtilisateur);
    ReponseUtilisateur fromEntity( ReponseUtilisateurEntity reponseUtilisateurEntity);
}
