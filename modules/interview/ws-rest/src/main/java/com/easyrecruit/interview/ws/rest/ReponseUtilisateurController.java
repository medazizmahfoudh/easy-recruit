package com.easyrecruit.interview.ws.rest;

import com.easyrecruit.interview.dal.entity.Question;
import com.easyrecruit.interview.dal.entity.ReponseUtilisateur;
import com.easyrecruit.interview.dal.entity.Resultat;
import com.easyrecruit.interview.dal.repository.ReponseRepository;
import com.easyrecruit.interview.dal.repository.ResultatRepository;
import com.easyrecruit.interview.infra.ResponseInput;
import com.easyrecruit.interview.infra.SubmissionResponse;
import com.easyrecruit.interview.infra.SubmitAnswersRequest;
import com.easyrecruit.interview.service.api.QuestionService;
import com.easyrecruit.interview.service.api.ReponseUtilisateurService;
import com.easyrecruit.management.dal.entity.CandidateEntity;
import com.easyrecruit.management.service.api.CandidateModule;
import com.easyrecruit.management.service.impl.CandidateModuleImpl;
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
    private ReponseUtilisateurService reponseUtilisateurService;



    @Autowired
    private QuestionService questionService;

    @Autowired
    private ReponseRepository reponseRepository;

    @Autowired
    private ResultatRepository resultatRepository;

    @Autowired
    private CandidateModuleImpl candidateService;

    /**
     * Soumettre les réponses d'un utilisateur pour un test et enregistrer le score.
     *
     */
};
