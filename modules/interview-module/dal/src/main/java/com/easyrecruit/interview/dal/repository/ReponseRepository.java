package com.easyrecruit.interview.dal.repository;

import com.easyrecruit.interview.dal.entity.ReponseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReponseRepository extends JpaRepository<ReponseEntity, Long> {
    // Si vous souhaitez récupérer une réponse spécifique par son ID
    Optional<ReponseEntity> findById(Long id);
    List<ReponseEntity> findByQuestionId(Long questionId);

}
