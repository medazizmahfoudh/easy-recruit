package com.easyrecruit.interview.impl.service;

import com.easyrecruit.interview.dal.entity.ReponseUtilisateurEntity;
import com.easyrecruit.interview.dal.repository.ResponseUtilisateurRepository;
import com.easyrecruit.interview.infra.Entity.ReponseUtilisateur;
import com.easyrecruit.interview.service.api.ReponseUtilisateurModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ReponseUtilisateurImpl  implements ReponseUtilisateurModule {

    private final ResponseUtilisateurRepository reponseUtilisateurRepository;

    @Autowired
    public ReponseUtilisateurImpl(ResponseUtilisateurRepository reponseUtilisateurRepository) {
        this.reponseUtilisateurRepository = reponseUtilisateurRepository;
    }

    @Override
    public void saveUserAnswers(List<ReponseUtilisateurEntity> reponsesUtilisateur) {
        reponseUtilisateurRepository.saveAll(reponsesUtilisateur);
    }

    @Override
    public List<ReponseUtilisateur> getUserAnswersByCandidatId(Long candidatId) {
        return reponseUtilisateurRepository.findByCandidatId(candidatId).stream()
                .map(reponseEntity -> {
                    ReponseUtilisateur reponseUtilisateur = new ReponseUtilisateur();
                    // Accéder au texte de la réponse via l'entité ReponseEntity
                    reponseUtilisateur.setReponse(reponseEntity.getReponse()); // Accès au texte de la réponse via ReponseEntity
                    reponseUtilisateur.setCandidat(reponseEntity.getCandidat()); // Si vous avez besoin de l'ID du candidat
                    reponseUtilisateur.setQuestion(reponseEntity.getQuestion()); // Ajouter la question associée
                    reponseUtilisateur.setCorrect(reponseEntity.isCorrect()); // Ajouter la validité de la réponse
                    return reponseUtilisateur;
                })
                .toList();
    }


}
