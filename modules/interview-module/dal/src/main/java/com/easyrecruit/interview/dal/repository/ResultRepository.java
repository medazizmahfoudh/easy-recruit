package com.easyrecruit.interview.dal.repository;

import com.easyrecruit.interview.dal.entity.ResultEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ResultRepository extends JpaRepository<ResultEntity, Long> {
    // Recherche par candidat, en utilisant l'entité CandidateEntity
    List<ResultEntity> findByCandidateId(Long candidate);

    // Recherche par candidat et sujet
    Optional<ResultEntity> findByCandidateIdAndTopic(Long candidateId, String topic);
}
