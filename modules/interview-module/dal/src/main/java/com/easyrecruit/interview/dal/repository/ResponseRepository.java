package com.easyrecruit.interview.dal.repository;

import com.easyrecruit.interview.dal.entity.ResponseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ResponseRepository extends JpaRepository<ResponseEntity, Long> {
    // Si vous souhaitez récupérer une réponse spécifique par son ID
    Optional<ResponseEntity> findById(Long id);
    List<ResponseEntity> findByQuestionId(Long questionId);

}
