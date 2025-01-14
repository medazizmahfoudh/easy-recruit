package com.easyrecruit.interview.service.api;

import com.easyrecruit.interview.dal.entity.ResultEntity;

import java.util.List;

public interface ResultModule {
    List<ResultEntity> getResultsByCandidate(Long candidateId);
}
