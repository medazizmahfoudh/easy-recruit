package com.easyrecruit.interview.service.api;

import com.easyrecruit.interview.dal.entity.QuestionEntity;
import com.easyrecruit.interview.dal.entity.ReponseEntity;
import com.easyrecruit.interview.infra.Entity.Question;
import com.easyrecruit.interview.infra.payload.QuestionWithResponsesDTO;
import org.springframework.stereotype.Service;

import java.util.*;

@Service

public interface QuestionModule {
    void addQuestionWithAnswers(Question question, List<ReponseEntity> reponses);

    List<Question> getAllQuestions();

    List<Question> getRandomQuestions(int count);

    Question getQuestionById(Long id);

    void deleteQuestion(Long id);

    List<Question> getQuestionsByTopic(String topic);

    List<QuestionWithResponsesDTO> getQuestionsWithResponses();

    String getGroupedQuestions();
    // Ajoutez cette méthode pour appeler la fonction SQL
    // Nouvelle méthode pour appeler la fonction SQL
    String getGroupedQuestionsWithIdByTopic();
}