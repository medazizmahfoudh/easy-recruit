package com.easyrecruit.interview.service.api;

import com.easyrecruit.interview.dal.entity.Resultat;
import com.easyrecruit.interview.dal.repository.ResultatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class ResultatService {
    private final ResultatRepository resultatRepository;


    @Autowired
    public ResultatService(ResultatRepository resultatRepository) {
        this.resultatRepository = resultatRepository;
    }

    // Méthode pour récupérer tous les résultats d'un candidat donné
    public List<Resultat> getResultsByCandidate(Long candidateId) {
        return resultatRepository.findByCandidateId(candidateId);
    }
}