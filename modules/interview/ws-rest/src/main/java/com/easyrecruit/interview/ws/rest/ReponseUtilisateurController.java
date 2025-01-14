package com.easyrecruit.interview.ws.rest;

import com.easyrecruit.interview.dal.repository.ReponseRepository;
import com.easyrecruit.interview.dal.repository.ResultatRepository;
import com.easyrecruit.interview.service.api.QuestionService;
import com.easyrecruit.interview.service.api.ReponseUtilisateurService;
import com.easyrecruit.management.service.impl.CandidateModuleImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

};
