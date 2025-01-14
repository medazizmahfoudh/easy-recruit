package com.easyrecruit.interview.service.api;

import com.easyrecruit.interview.infra.Entity.Result;
import com.easyrecruit.management.infra.model.entity.Candidate;

import java.util.List;

public interface ResultModule {
    List<Result> getResultsByCandidate(Long candidateId);
    void save(Result result);
    Result findByCandidateAndTopic(Candidate candidate, String topic) throws Exception;
}
