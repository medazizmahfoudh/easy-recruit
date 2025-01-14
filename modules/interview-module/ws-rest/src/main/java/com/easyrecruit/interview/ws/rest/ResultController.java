package com.easyrecruit.interview.ws.rest;

import com.easyrecruit.interview.infra.Entity.Result;
import com.easyrecruit.interview.service.api.ResultModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ResultController {
    private final ResultModule resultModule;

    @Autowired
    public ResultController(ResultModule resultModule) {
        this.resultModule = resultModule;
    }

    @GetMapping("/candidates/{candidateId}/results")
    public List<Result> getResultsByCandidate(@PathVariable Long candidateId) {
        return resultModule.getResultsByCandidate(candidateId);
    }

}
