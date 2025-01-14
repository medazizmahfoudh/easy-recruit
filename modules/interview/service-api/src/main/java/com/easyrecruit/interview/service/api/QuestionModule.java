package com.easyrecruit.interview.service.api;

import com.easyrecruit.interview.dal.entity.QuestionEntity;
import com.easyrecruit.interview.dal.entity.ReponseEntity;
import com.easyrecruit.interview.dal.repository.QuestionRepository;
import com.easyrecruit.interview.dal.repository.ReponseRepository;
import com.easyrecruit.interview.dal.repository.ResponseUtilisateurRepository;
import com.easyrecruit.interview.infra.payload.QuestionWithResponsesDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service

public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private ResponseUtilisateurRepository reponseUtilisateurRepository;

    @Autowired
    private ReponseRepository reponseRepository;
    /**
     * Ajoute une question avec ses réponses associées.
     *
     * @param question La question à ajouter.
     * @param reponses La liste des réponses associées.
     */
    @Transactional
    public void addQuestionWithAnswers(QuestionEntity question, List<ReponseEntity> reponses) {
        if (question.getTopic() == null || question.getTopic().isEmpty()) {
            throw new IllegalArgumentException("Le sujet de la question (topic) est requis.");
        }
        questionRepository.save(question); // Sauvegarde de la question avec son topic

        for (ReponseEntity reponse : reponses) {
            if (reponse.getReponseText() == null || reponse.getReponseText().isEmpty()) {
                throw new IllegalArgumentException("La réponse ne peut pas être vide.");
            }
            reponse.setQuestion(question);
            reponseRepository.save(reponse);
        }
    }





    /**
     * Récupère toutes les questions.
     *
     * @return Une liste de toutes les questions avec leurs réponses.
     */
    public List<QuestionEntity> getAllQuestions() {
        return questionRepository.findAll();
    }

    /**
     * Récupère un ensemble aléatoire de questions pour le test.
     *
     * @param count Le nombre de questions à récupérer.
     * @return Une liste de questions aléatoires.
     */
    public List<QuestionEntity> getRandomQuestions(int count) {
        List<QuestionEntity> allQuestions = questionRepository.findAll();
        Collections.shuffle(allQuestions); // Mélanger les questions
        return allQuestions.stream().limit(count).toList();
    }
    public QuestionEntity getQuestionById(Long id) {
        Optional<QuestionEntity> question = questionRepository.findById(id);
        return question.orElseThrow(() -> new RuntimeException("Question not found with id " + id));  // Si non trouvé, lève une exception
    }


    public void deleteQuestion(Long id) {
        QuestionEntity question = questionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Question not found with id " + id));
        questionRepository.delete(question);
    }



    public List<QuestionEntity> getQuestionsByTopic(String topic) {
        return questionRepository.findByTopic(topic);
    }





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
    public String getGroupedQuestions() {
        return questionRepository.getGroupedQuestionsByTopic();
    }
}