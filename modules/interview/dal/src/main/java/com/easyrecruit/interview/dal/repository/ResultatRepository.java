package com.easyrecruit.interview.dal.repository;

import com.easyrecruit.interview.dal.entity.Result;
import com.easyrecruit.management.infra.model.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ResultatRepository extends JpaRepository<Result, Long> {
    // Méthode pour trouver un résultat par l'ID du candidat
    List<Result> findByCandidateId(Long candidateId);
    Optional<Result> findByCandidateAndTopic(Candidate candidate, String topic);


}