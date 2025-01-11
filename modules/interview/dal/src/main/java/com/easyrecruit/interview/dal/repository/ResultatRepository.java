package com.easyrecruit.interview.dal.repository;

import com.easyrecruit.interview.dal.entity.ReponseUtilisateur;
import com.easyrecruit.interview.dal.entity.Resultat;
import com.easyrecruit.management.infra.model.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ResultatRepository extends JpaRepository<Resultat, Long> {
    // Méthode pour trouver un résultat par l'ID du candidat
    List<Resultat> findByCandidateId(Long candidateId);
    Optional<Resultat> findByCandidateAndTopic(Candidate candidate, String topic);


}