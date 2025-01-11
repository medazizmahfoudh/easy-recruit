package com.easyrecruit.interview.ws.rest;

import com.easyrecruit.interview.dal.entity.Resultat;
import com.easyrecruit.interview.service.api.ResultatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ResultatController {
    private final ResultatService resultatService;

    @Autowired
    public ResultatController(ResultatService resultatService) {
        this.resultatService = resultatService;
    }

    // Endpoint pour récupérer les résultats d'un candidat par son ID
    @GetMapping("/candidates/{candidateId}/results")
    public List<Resultat> getResultsByCandidate(@PathVariable Long candidateId) {
        return resultatService.getResultsByCandidate(candidateId);
    }
}
