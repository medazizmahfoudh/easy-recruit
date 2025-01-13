package com.easyrecruit.evaluation.service.impl;

import com.easyrecruit.management.infra.model.entity.Application;
import com.easyrecruit.management.infra.model.entity.Evaluation;

import java.util.List;

public interface CandidateService {

    public Evaluation processApplication(Application application);

    public List<Evaluation> processApplicationByStatus();

    Evaluation processApplicationById(String uiid);

}
