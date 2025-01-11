package com.easyrecruit.interview.ws.rest;


import com.easyrecruit.interview.dal.entity.Question;
import com.easyrecruit.interview.dal.entity.Reponse;
import com.easyrecruit.interview.infra.QuestionWithAnswersDto;
import com.easyrecruit.interview.infra.QuestionWithResponsesDTO;
import com.easyrecruit.interview.service.api.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    /**
     * Ajouter une nouvelle question avec ses réponses.
     *
     * @param questionWithAnswersDto La question et ses réponses associées.
     * @return La question ajoutée.
     */


    /**
     * Modifier une question existante.
     *
     * @param id L'ID de la question à modifier.
     * @return La question mise à jour.
     */
    @PostMapping
    public ResponseEntity<Question> addQuestionWithAnswers(@RequestBody QuestionWithAnswersDto questionWithAnswersDto) {
        // Récupérer la question et son topic
        Question question = questionWithAnswersDto.getQuestion();
        question.setTopic(questionWithAnswersDto.getTopic());

        // Récupérer les réponses associées
        List<Reponse> reponses = questionWithAnswersDto.getReponses();

        // Ajouter la question et ses réponses
        questionService.addQuestionWithAnswers(question, reponses);

        return ResponseEntity.ok(question);
    }





    /**
     * Supprimer une question par son ID.
     *
     * @param id L'ID de la question à supprimer.
     * @return Une réponse vide si la suppression est réussie.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable Long id) {
        questionService.deleteQuestion(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Récupérer toutes les questions.
     *
     * @return Une liste de toutes les questions.
     */
    @GetMapping
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @PostMapping("/bulk")
    public ResponseEntity<String> addMultipleQuestions(@RequestBody Map<String, List<QuestionWithAnswersDto>> questionsByTopic) {
        // Vérifier que chaque sujet contient entre 10 et 15 questions
        for (Map.Entry<String, List<QuestionWithAnswersDto>> entry : questionsByTopic.entrySet()) {
            List<QuestionWithAnswersDto> questionsWithAnswersDtoList = entry.getValue();

            if (questionsWithAnswersDtoList.size() < 10 || questionsWithAnswersDtoList.size() > 15) {
                return ResponseEntity.badRequest().body("Le sujet '" + entry.getKey() + "' doit contenir entre 10 et 15 questions.");
            }

            // Pour chaque question dans chaque sujet
            for (QuestionWithAnswersDto questionWithAnswersDto : questionsWithAnswersDtoList) {
                // Créer l'objet Question à partir du DTO
                Question question = questionWithAnswersDto.getQuestion();
                question.setTopic(entry.getKey());  // définir le sujet en fonction de l'entrée du Map

                // Récupérer les réponses associées à cette question
                List<Reponse> reponses = questionWithAnswersDto.getReponses();

                // Ajouter la question et ses réponses dans la base de données
                questionService.addQuestionWithAnswers(question, reponses);
            }
        }

        return ResponseEntity.ok("Questions ajoutées avec succès.");
    }




    @GetMapping("/questions-with-responses")
    public List<QuestionWithResponsesDTO> getQuestionsWithResponses() {
        return questionService.getQuestionsWithResponses();
    }
    @GetMapping("/grouped")
    public String getGroupedQuestions() {
        return questionService.getGroupedQuestions();
    }
}