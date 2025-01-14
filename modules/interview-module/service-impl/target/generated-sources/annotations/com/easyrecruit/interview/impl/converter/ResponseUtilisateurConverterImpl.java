package com.easyrecruit.interview.impl.converter;

import com.easyrecruit.interview.dal.entity.ReponseUtilisateurEntity;
import com.easyrecruit.interview.infra.Entity.ReponseUtilisateur;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-14T10:28:07+0100",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.11 (Amazon.com Inc.)"
)
public class ResponseUtilisateurConverterImpl implements ResponseUtilisateurConverter {

    @Override
    public ReponseUtilisateurEntity toEntity(ReponseUtilisateur reponseUtilisateur) {
        if ( reponseUtilisateur == null ) {
            return null;
        }

        ReponseUtilisateurEntity reponseUtilisateurEntity = new ReponseUtilisateurEntity();

        reponseUtilisateurEntity.setId( reponseUtilisateur.getId() );
        reponseUtilisateurEntity.setCandidat( reponseUtilisateur.getCandidat() );
        reponseUtilisateurEntity.setQuestion( reponseUtilisateur.getQuestion() );
        reponseUtilisateurEntity.setReponse( reponseUtilisateur.getReponse() );
        reponseUtilisateurEntity.setCorrect( reponseUtilisateur.isCorrect() );

        return reponseUtilisateurEntity;
    }

    @Override
    public ReponseUtilisateur fromEntity(ReponseUtilisateurEntity reponseUtilisateurEntity) {
        if ( reponseUtilisateurEntity == null ) {
            return null;
        }

        ReponseUtilisateur reponseUtilisateur = new ReponseUtilisateur();

        reponseUtilisateur.setId( reponseUtilisateurEntity.getId() );
        reponseUtilisateur.setQuestion( reponseUtilisateurEntity.getQuestion() );
        reponseUtilisateur.setReponse( reponseUtilisateurEntity.getReponse() );
        reponseUtilisateur.setCorrect( reponseUtilisateurEntity.isCorrect() );

        return reponseUtilisateur;
    }
}
