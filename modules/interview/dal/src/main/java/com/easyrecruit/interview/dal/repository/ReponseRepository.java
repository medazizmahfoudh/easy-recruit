package com.easyrecruit.interview.dal.repository;

import com.easyrecruit.interview.dal.entity.Reponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReponseRepository extends JpaRepository<Reponse, Long> {
    // Si vous souhaitez récupérer une réponse spécifique par son ID
    Optional<Reponse> findById(Long id);
    List<Reponse> findByQuestionId(Long questionId);

}
