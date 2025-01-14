package com.easyrecruit.interview.ws.rest;


import com.easyrecruit.interview.infra.Entity.Question;
import com.easyrecruit.interview.infra.Entity.Response;
import com.easyrecruit.interview.infra.payload.QuestionWithAnswersDto;
import com.easyrecruit.interview.infra.payload.QuestionWithResponsesDTO;
import com.easyrecruit.interview.service.api.QuestionModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private QuestionModule questionModule;


    @PostMapping
    public org.springframework.http.ResponseEntity<Question> addQuestionWithAnswers(@RequestBody QuestionWithAnswersDto questionWithAnswersDto) {
        // Récupérer la question et son topic
        Question question = questionWithAnswersDto.getQuestion();
        question.setTopic(questionWithAnswersDto.getTopic());

        // Récupérer les réponses associées
        List<Response> reponses = questionWithAnswersDto.getResponses();

        // Ajouter la question et ses réponses
        questionModule.addQuestionWithAnswers(question, reponses);

        return org.springframework.http.ResponseEntity.ok(question);
    }

    @DeleteMapping("/{id}")
    public org.springframework.http.ResponseEntity<Void> deleteQuestion(@PathVariable Long id) {
        questionModule.deleteQuestion(id);
        return org.springframework.http.ResponseEntity.noContent().build();
    }

    @GetMapping
    public List<Question> getAllQuestions() {
        return questionModule.getAllQuestions();
    }

    @PostMapping("/bulk")
    public org.springframework.http.ResponseEntity<String> addMultipleQuestions(@RequestBody Map<String, List<QuestionWithAnswersDto>> questionsByTopic) {
        // Vérifier que chaque sujet contient entre 10 et 15 questions
        for (Map.Entry<String, List<QuestionWithAnswersDto>> entry : questionsByTopic.entrySet()) {
            List<QuestionWithAnswersDto> questionsWithAnswersDtoList = entry.getValue();

            if (questionsWithAnswersDtoList.size() < 10 || questionsWithAnswersDtoList.size() > 15) {
                return org.springframework.http.ResponseEntity.badRequest().body("Le sujet '" + entry.getKey() + "' doit contenir entre 10 et 15 questions.");
            }

            // Pour chaque question dans chaque sujet
            for (QuestionWithAnswersDto questionWithAnswersDto : questionsWithAnswersDtoList) {
                // Créer l'objet Question à partir du DTO
                Question question = questionWithAnswersDto.getQuestion();
                question.setTopic(entry.getKey());  // définir le sujet en fonction de l'entrée du Map

                // Récupérer les réponses associées à cette question
                List<Response> reponses = questionWithAnswersDto.getResponses();

                // Ajouter la question et ses réponses dans la base de données
                questionModule.addQuestionWithAnswers(question, reponses);
            }
        }

        return org.springframework.http.ResponseEntity.ok("Questions ajoutées avec succès.");
    }

    @GetMapping("/questions-with-responses")
    public List<QuestionWithResponsesDTO> getQuestionsWithResponses() {
        return questionModule.getQuestionsWithResponses();
    }
    @GetMapping("/grouped")
    public String getGroupedQuestionsWithIdByTopic() {
        return questionModule.getGroupedQuestionsWithIdByTopic();
    }
}
