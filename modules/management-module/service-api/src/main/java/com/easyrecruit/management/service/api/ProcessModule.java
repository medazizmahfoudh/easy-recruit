package com.easyrecruit.management.service.api;

import com.easyrecruit.management.infra.model.entity.Application;
import com.easyrecruit.management.infra.model.entity.Evaluation;

import java.util.List;

public interface ProcessModule {

    List<Evaluation> classifyAll();
    void classify(Application application);
    void classify(List<Application> applications);
}
