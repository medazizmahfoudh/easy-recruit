package com.easyrecruit.interview.dal.repository;

import com.easyrecruit.interview.dal.entity.QuestionEntity;
import com.easyrecruit.interview.dal.entity.ResponseEntity;
import com.easyrecruit.interview.dal.entity.ResponseUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ResponseUserRepository extends JpaRepository<ResponseUserEntity, Long> {


    List<ResponseUserEntity> findByCandidatId(Long candidatId);
    Optional<ResponseUserEntity> findByQuestionAndReponse(QuestionEntity question, ResponseEntity reponse);
    @Query("SELECT r FROM ResponseEntity r WHERE r.question = :question AND r.correct = true")
    ResponseEntity findCorrectReponseByQuestion(@Param("question") QuestionEntity question);


}
