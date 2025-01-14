package com.easyrecruit.interview.ws.rest;

import com.easyrecruit.interview.infra.Entity.Question;
import com.easyrecruit.interview.infra.Entity.ResponseUser;
import com.easyrecruit.interview.infra.Entity.Result;
import com.easyrecruit.interview.infra.payload.ResponseInput;
import com.easyrecruit.interview.infra.payload.SubmissionResponse;
import com.easyrecruit.interview.infra.payload.SubmitAnswersRequest;
import com.easyrecruit.interview.service.api.QuestionModule;
import com.easyrecruit.interview.service.api.ResponseUserModule;
import com.easyrecruit.interview.service.api.ResultModule;
import com.easyrecruit.management.infra.model.entity.Candidate;
import com.easyrecruit.management.service.api.CandidateModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/api/reponses")
public class ResponseUserController {

    @Autowired
    private ResponseUserModule responseUserModule;

    @Autowired
    private CandidateModule candidateModule;

    @Autowired
    private QuestionModule questionModule;

    @Autowired
    private ResultModule resultModule;


    @PostMapping("/submit")
    public ResponseEntity<SubmissionResponse> submitAnswers(
            @RequestBody SubmitAnswersRequest request,
            @RequestParam Long candidateId,
            @RequestParam String topic) throws Exception {

        List<ResponseInput> responses = request.getResponses();

        // Récupération du candidat
        Candidate candidate = candidateModule.getCandidateById(candidateId);
        if (candidate == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        // Vérifier si le candidat a déjà passé le test
        Result existingResult = resultModule.findByCandidateAndTopic(candidate, topic);

        // Filtrage des questions par "topic"
        List<Question> questionsByTopic = questionModule.getQuestionsByTopic(topic);
        if (questionsByTopic.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Aucune question pour ce topic
        }

        // Vérification des réponses et calcul du score
        AtomicInteger score = new AtomicInteger(0);
        List<ResponseUser> reponsesUtilisateurEntities = responses.stream()
                .map(response -> {
                    Long questionId = response.getQuestionId();
                    String selectedAnswer = response.getSelectedAnswer();

                    // Recherche de la question par ID et par topic
                    Question question = questionsByTopic.stream()
                            .filter(q -> q.getId().equals(questionId))
                            .findFirst()
                            .orElseThrow(() -> new IllegalArgumentException("Question introuvable pour le topic " + topic));

                    // Vérification si la réponse sélectionnée est correcte
                    boolean isCorrect = question.getCorrectAnswer().equals(selectedAnswer);
                    if (isCorrect) {
                        score.incrementAndGet();
                    }

                    // Création d'une nouvelle réponse utilisateur entity
                    ResponseUser responseUserEntity = new ResponseUser();
                    responseUserEntity.setCandidate(candidate);
                    responseUserEntity.setQuestion(question);
                    responseUserEntity.setCorrect(isCorrect);

                    return responseUserEntity;
                })
                .collect(Collectors.toList());

        // Sauvegarde des réponses de l'utilisateur
        responseUserModule.saveUserAnswers(reponsesUtilisateurEntities);

        // Création du résultat
        Result result = new Result();
        result.setCandidate(candidate); // Entité candidate
        result.setScore(score.get());
        result.setTopic(topic); // Enregistrement du topic
        result.setTotalQuestions(questionsByTopic.size()); // Total des questions
        result.setCorrectQuestions(score.get()); // Total des réponses correctes

        // Sauvegarde dans la base de données
        resultModule.save(result);

        // Création de la réponse de soumission
        SubmissionResponse submissionResponse = new SubmissionResponse();
        submissionResponse.setScore(score.get());
        submissionResponse.setTotalQuestions(questionsByTopic.size());
        submissionResponse.setCorrectAnswers(responses.stream()
                .filter(response -> questionModule.getQuestionById(response.getQuestionId()).getCorrectAnswer().equals(response.getSelectedAnswer()))
                .map(ResponseInput::getQuestionId)
                .collect(Collectors.toList()));

        // Retourner la réponse de soumission
        return ResponseEntity.ok(submissionResponse);
    }

}
