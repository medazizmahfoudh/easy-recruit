package com.easyrecruit.interview.dal.repository;

import com.easyrecruit.interview.dal.entity.Response;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReponseRepository extends JpaRepository<Response, Long> {
    // Si vous souhaitez récupérer une réponse spécifique par son ID
    Optional<Response> findById(Long id);
    List<Response> findByQuestionId(Long questionId);

}