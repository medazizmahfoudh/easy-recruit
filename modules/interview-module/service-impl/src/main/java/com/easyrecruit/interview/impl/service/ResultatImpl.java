package com.easyrecruit.interview.impl.service;

import com.easyrecruit.interview.dal.entity.ResultatEntity;
import com.easyrecruit.interview.dal.repository.ResultatRepository;
import com.easyrecruit.interview.service.api.ResultatModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ResultatImpl  implements ResultatModule {

    private final ResultatRepository resultatRepository;

    @Autowired
    public ResultatImpl(ResultatRepository resultatRepository) {
        this.resultatRepository = resultatRepository;
    }

    @Override
    public List<ResultatEntity> getResultsByCandidate(Long candidateId) {
        return resultatRepository.findByCandidateId(candiqateId);
    }

}
