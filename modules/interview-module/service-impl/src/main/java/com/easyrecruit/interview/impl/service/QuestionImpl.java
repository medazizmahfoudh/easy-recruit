package com.easyrecruit.interview.impl.service;

import com.easyrecruit.interview.dal.entity.QuestionEntity;
import com.easyrecruit.interview.dal.entity.ResponseEntity;
import com.easyrecruit.interview.dal.repository.QuestionRepository;
import com.easyrecruit.interview.dal.repository.ResponseRepository;
import com.easyrecruit.interview.dal.repository.ResponseUserRepository;
import com.easyrecruit.interview.impl.converter.QuestionConverter;
import com.easyrecruit.interview.infra.Entity.Question;
import com.easyrecruit.interview.infra.payload.QuestionWithResponsesDTO;
import com.easyrecruit.interview.service.api.QuestionModule;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service

public class QuestionImpl implements QuestionModule {

    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private ResponseUserRepository responseUserRepository;
    @Autowired
    private ResponseRepository responseRepository;




    @Override
    @Transactional
    public void addQuestionWithAnswers(Question question, List<ResponseEntity> reponses) {
        if (question.getTopic() == null || question.getTopic().isEmpty()) {
            throw new IllegalArgumentException("Le sujet de la question (topic) est requis.");
        }

        QuestionEntity questionEntity = QuestionConverter.INSTANCE.toEntity(question);
        questionRepository.save(questionEntity); // Sauvegarde de la question avec son topic

        for (ResponseEntity reponse : reponses) {
            if (reponse.getResponseText() == null || reponse.getResponseText().isEmpty()) {
                throw new IllegalArgumentException("La réponse ne peut pas être vide.");
            }
            reponse.setQuestion(questionEntity);
            responseRepository.save(reponse);
        }
    }

    @Override
    public List<Question> getAllQuestions() {
        return questionRepository.findAll().stream()
                .map(QuestionConverter.INSTANCE::fromEntity)
                .toList();
    }

    @Override
    public List<Question> getRandomQuestions(int count) {
        List<QuestionEntity> allQuestions = questionRepository.findAll();
        Collections.shuffle(allQuestions); // Mélanger les questions
        return allQuestions.stream()
                .limit(count)
                .map(QuestionConverter.INSTANCE::fromEntity)
                .toList();
    }
    @Override
    public Question getQuestionById(Long id) {
        QuestionEntity questionEntity = questionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Question not found with id " + id));
        return QuestionConverter.INSTANCE.fromEntity(questionEntity);
    }



    public String getGroupedQuestionsWithIdByTopic() {
        return questionRepository.getGroupedQuestionsWithIdByTopic();
    }
    @Override
    public void deleteQuestion(Long id) {
        QuestionEntity questionEntity = questionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Question not found with id " + id));
        questionRepository.delete(questionEntity);
    }

    @Override
    public List<Question> getQuestionsByTopic(String topic) {

        return questionRepository.findByTopic(topic).stream()
                .map(QuestionConverter.INSTANCE::fromEntity)
                .toList();
    }

    @Override
    public List<QuestionWithResponsesDTO> getQuestionsWithResponses() {
        List<Object[]> rawResults = questionRepository.getQuestionsWithResponses();
        List<QuestionWithResponsesDTO> result = new ArrayList<>();

        for (Object[] row : rawResults) {
            String topic = (String) row[0];
            String question = (String) row[1];
            String[] responsesArray = (String[]) row[2]; // PostgreSQL ARRAY maps to Java array

            result.add(new QuestionWithResponsesDTO(topic, question, Arrays.asList(responsesArray)));
        }
        return result;
    }

    @Override
    public String getGroupedQuestions() {
        return questionRepository.getGroupedQuestionsByTopic();
    }


}
