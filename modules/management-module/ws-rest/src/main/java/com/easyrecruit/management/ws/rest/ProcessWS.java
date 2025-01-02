package com.easyrecruit.management.ws.rest;

import com.easyrecruit.management.infra.model.entity.Evaluation;
import com.easyrecruit.management.service.api.ProcessModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/process")
public class ProcessWS {

    @Autowired
    private ProcessModule processModule;

    @PostMapping("/classify-all")
    public ResponseEntity<List<Evaluation>> classifyEvaluations() {
        return ResponseEntity.ok(processModule.classifyAll());
    }
}
