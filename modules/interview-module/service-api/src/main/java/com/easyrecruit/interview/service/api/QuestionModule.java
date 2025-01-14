package com.easyrecruit.interview.service.api;

import com.easyrecruit.interview.infra.Entity.Question;
import com.easyrecruit.interview.infra.Entity.Response;
import com.easyrecruit.interview.infra.payload.QuestionWithResponsesDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface QuestionModule {
    void addQuestionWithAnswers(Question question, List<Response> responses);
    List<Question> getAllQuestions();
    List<Question> getRandomQuestions(int count);
    Question getQuestionById(Long id);
    void deleteQuestion(Long id);
    List<Question> getQuestionsByTopic(String topic);
    List<QuestionWithResponsesDTO> getQuestionsWithResponses();
    String getGroupedQuestions();
    String getGroupedQuestionsWithIdByTopic();
}