package com.easyrecruit.interview.dal.repository;

import com.easyrecruit.interview.dal.entity.ResultatEntity;
import com.easyrecruit.management.dal.entity.CandidateEntity;  // Assurez-vous d'importer CandidateEntity
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ResultatRepository extends JpaRepository<ResultatEntity, Long> {
    // Recherche par candidat, en utilisant l'entité CandidateEntity
    List<ResultatEntity> findByCandidateId(Long candidate);

    // Recherche par candidat et sujet
    Optional<ResultatEntity> findByCandidateAndTopic(CandidateEntity candidate, String topic);
}
