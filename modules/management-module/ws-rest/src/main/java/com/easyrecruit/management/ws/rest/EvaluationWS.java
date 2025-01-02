package com.easyrecruit.management.ws.rest;

import com.easyrecruit.management.infra.model.entity.Evaluation;
import com.easyrecruit.management.service.api.EvaluationModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evaluation")
public class EvaluationWS {

    @Autowired
    private EvaluationModule evaluationModule;

    @PutMapping("/update/{uuid}")
    public ResponseEntity<Evaluation> updateEvaluation(@PathVariable("uuid") String uuid, @RequestParam Double score) {
        return ResponseEntity.ok(evaluationModule.updateEvaluationScore(uuid, score));
    }

    @GetMapping("/get")
    public ResponseEntity<List<Evaluation>> getAllEvaluations() {
        return ResponseEntity.ok(evaluationModule.getAllEvaluations());
    }
}
