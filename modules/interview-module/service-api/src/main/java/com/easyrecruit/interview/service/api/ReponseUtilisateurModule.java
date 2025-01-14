package com.easyrecruit.interview.service.api;

import com.easyrecruit.interview.dal.entity.ReponseUtilisateurEntity;
import com.easyrecruit.interview.infra.Entity.ReponseUtilisateur;

import java.util.List;
public interface  ReponseUtilisateurModule {
    void saveUserAnswers(List<ReponseUtilisateurEntity> reponsesUtilisateur);

    List<ReponseUtilisateur> getUserAnswersByCandidatId(Long candidatId);
}