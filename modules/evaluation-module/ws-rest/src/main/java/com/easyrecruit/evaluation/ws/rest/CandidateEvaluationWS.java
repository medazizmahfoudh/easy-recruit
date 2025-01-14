package com.easyrecruit.evaluation.ws.rest;

import com.easyrecruit.evaluation.service.CandidateService;
import com.easyrecruit.management.infra.model.entity.Evaluation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evaluation")
public class CandidateEvaluationWS {


    @Autowired
    private CandidateService candidateService;

    @PostMapping("/process/{id}")
    public ResponseEntity<Evaluation> processApplicationById(@PathVariable String id){
        return ResponseEntity.ok(candidateService.processApplicationById(id));
    }

    @GetMapping("/processByStatus")
    public ResponseEntity<List<Evaluation>> processCandidatesByStatus(){
        return ResponseEntity.ok(candidateService.processApplicationByStatus());


    }

}
