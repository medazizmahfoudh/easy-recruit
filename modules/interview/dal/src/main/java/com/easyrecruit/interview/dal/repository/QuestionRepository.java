package com.easyrecruit.interview.dal.repository;

import com.easyrecruit.interview.dal.entity.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository

public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findByTopic(String topic);

    @Query(value = "SELECT get_grouped_questions_by_topic()", nativeQuery = true)
    String getGroupedQuestionsByTopic();
    @Query(value = "SELECT * FROM get_questions_with_grouped_responses_by_topic()", nativeQuery = true)
    List<Object[]> getQuestionsWithResponses();
    Optional<Question> findById(Long id);
    Page<Question> findByTopic(String topic, Pageable pageable);}

