package com.easyrecruit.interview.ws.rest;

import com.easyrecruit.interview.dal.entity.QuestionEntity;
import com.easyrecruit.interview.dal.entity.ReponseUtilisateurEntity;
import com.easyrecruit.interview.dal.entity.ResultatEntity;
import com.easyrecruit.interview.dal.repository.ResultatRepository;
import com.easyrecruit.interview.infra.Entity.Question;
import com.easyrecruit.interview.infra.payload.ResponseInput;
import com.easyrecruit.interview.infra.payload.SubmissionResponse;
import com.easyrecruit.interview.infra.payload.SubmitAnswersRequest;
import com.easyrecruit.interview.service.api.QuestionModule;
import com.easyrecruit.interview.service.api.ReponseUtilisateurModule;
import com.easyrecruit.management.dal.entity.CandidateEntity;
import com.easyrecruit.management.infra.model.entity.Candidate;
import com.easyrecruit.management.service.api.CandidateModule;
import com.easyrecruit.management.service.impl.converter.CandidateConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/api/reponses")
public class ReponseUtilisateurController {

    @Autowired
    private ReponseUtilisateurModule reponseUtilisateurService;

    @Autowired
    private CandidateModule candidateModule;

    @Autowired
    private QuestionModule questionService;

    @Autowired
    private ResultatRepository resultatRepository;

    /**
     * Soumettre les réponses d'un utilisateur pour un test et enregistrer le score.
     *
     * @param request       Contient les réponses soumises par l'utilisateur.
     * @param cadidatid   du candidat.
     * @param topic         Sujet des questions.
     * @return La réponse contenant le score et les réponses correctes.
     */
    @PostMapping("/submit")
    public ResponseEntity<SubmissionResponse> submitAnswers(
            @RequestBody SubmitAnswersRequest request,
            @RequestParam Long candidatid,
            @RequestParam String topic) {

        List<ResponseInput> responses = request.getResponses();

        // Récupération du candidat
        Candidate candidat = candidateModule.getCandidateById(candidatid);
        if (candidat == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        // Conversion en CandidateEntity
        CandidateEntity candidateEntity = CandidateConverter.INSTANCE.toEntity(candidat);

        // Vérifier si le candidat a déjà passé le test
        Optional<ResultatEntity> existingResult = resultatRepository.findByCandidateAndTopic(candidateEntity, topic);
        if (existingResult.isPresent()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null); // Test déjà passé
        }

        // Filtrage des questions par "topic"
        List<Question> questionsByTopic = questionService.getQuestionsByTopic(topic);
        if (questionsByTopic.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Aucune question pour ce topic
        }

        // Vérification des réponses et calcul du score
        AtomicInteger score = new AtomicInteger(0);
        List<ReponseUtilisateurEntity> reponsesUtilisateurEntities = responses.stream()
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
                    ReponseUtilisateurEntity reponseUtilisateurEntity = new ReponseUtilisateurEntity();
                    reponseUtilisateurEntity.setCandidat(candidateEntity);
                    reponseUtilisateurEntity.setQuestion( new QuestionEntity(questionId));
                    reponseUtilisateurEntity.setCorrect(isCorrect);

                    return reponseUtilisateurEntity;
                })
                .collect(Collectors.toList());

        // Sauvegarde des réponses de l'utilisateur
        reponseUtilisateurService.saveUserAnswers(reponsesUtilisateurEntities);

        // Création du résultat
        ResultatEntity resultatEntity = new ResultatEntity();
        resultatEntity.setCandidate(candidateEntity); // Entité candidate
        resultatEntity.setScore(score.get());
        resultatEntity.setTopic(topic); // Enregistrement du topic
        resultatEntity.setTotalQuestions(questionsByTopic.size()); // Total des questions
        resultatEntity.setCorrectQuestions(score.get()); // Total des réponses correctes

        // Sauvegarde dans la base de données
        resultatRepository.save(resultatEntity);

        // Création de la réponse de soumission
        SubmissionResponse submissionResponse = new SubmissionResponse();
        submissionResponse.setScore(score.get());
        submissionResponse.setTotalQuestions(questionsByTopic.size());
        submissionResponse.setCorrectAnswers(responses.stream()
                .filter(response -> questionService.getQuestionById(response.getQuestionId()).getCorrectAnswer().equals(response.getSelectedAnswer()))
                .map(ResponseInput::getQuestionId)
                .collect(Collectors.toList()));

        // Retourner la réponse de soumission
        return ResponseEntity.ok(submissionResponse);
    }

}
