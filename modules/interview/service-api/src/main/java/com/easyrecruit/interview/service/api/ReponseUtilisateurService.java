package com.easyrecruit.interview.service.api;

import com.easyrecruit.interview.dal.entity.ReponseUtilisateur;
import com.easyrecruit.interview.dal.repository.ResponseUtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReponseUtilisateurService {
    @Autowired
    private ResponseUtilisateurRepository reponseUtilisateurRepository;

    /**
     * Enregistre les réponses des utilisateurs.
     *
     * @param reponsesUtilisateur Liste des réponses des utilisateurs à enregistrer.
     */
    public void saveUserAnswers(List<ReponseUtilisateur> reponsesUtilisateur) {
        reponseUtilisateurRepository.saveAll(reponsesUtilisateur);
    }


    /**
     * Récupère toutes les réponses d'un candidat spécifique.
     *
     * @param candidatId L'ID du candidat.
     * @return Liste des réponses utilisateur associées à ce candidat.
     */
    public List<ReponseUtilisateur> getUserAnswersByCandidatId(Long candidatId) {
        return reponseUtilisateurRepository.findByCandidatId(candidatId);
    }
}