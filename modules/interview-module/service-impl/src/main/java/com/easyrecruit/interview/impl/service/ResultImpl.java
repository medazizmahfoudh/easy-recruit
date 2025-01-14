package com.easyrecruit.interview.impl.service;

import com.easyrecruit.interview.dal.entity.ResultEntity;
import com.easyrecruit.interview.dal.repository.ResultRepository;
import com.easyrecruit.interview.service.api.ResultModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ResultImpl implements ResultModule {

    private final ResultRepository resultRepository;

    @Autowired
    public ResultImpl(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    @Override
    public List<ResultEntity> getResultsByCandidate(Long candidateId) {
        return resultRepository.findByCandidateId(candidateId);
    }

}
