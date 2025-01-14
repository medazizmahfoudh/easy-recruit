package com.easyrecruit.interview.impl.service;

import com.easyrecruit.interview.dal.entity.ResultEntity;
import com.easyrecruit.interview.dal.repository.ResultRepository;
import com.easyrecruit.interview.impl.converter.ResultConverter;
import com.easyrecruit.interview.infra.Entity.Result;
import com.easyrecruit.interview.service.api.ResultModule;
import com.easyrecruit.management.infra.model.entity.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ResultImpl implements ResultModule {

    private final ResultRepository resultRepository;

    @Autowired
    public ResultImpl(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    @Override
    public List<Result> getResultsByCandidate(Long candidateId) {
        return resultRepository.findByCandidateId(candidateId).stream()
                .map(ResultConverter.INSTANCE::fromEntity)
                .toList();
    }

    @Override
    public void save(Result result) {
        resultRepository.save(ResultConverter.INSTANCE.toEntity(result));
    }

    @Override
    public Result findByCandidateAndTopic(Candidate candidate, String topic) throws Exception {
        Optional<ResultEntity> resultEntity = resultRepository.findByCandidateIdAndTopic(candidate.getId(), topic);
        if (resultEntity.isEmpty()) {
            throw new Exception("No result found for candidate " + candidate.getId() + " and topic " + topic);
        }
        return ResultConverter.INSTANCE.fromEntity(resultEntity.get());
    }

}
