package com.easyrecruit.interview.service.api;

import com.easyrecruit.interview.dal.entity.ResultatEntity;
import com.easyrecruit.interview.dal.repository.ResultatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ResultatModule {
    List<ResultatEntity> getResultsByCandidate(Long candidateId);

}
