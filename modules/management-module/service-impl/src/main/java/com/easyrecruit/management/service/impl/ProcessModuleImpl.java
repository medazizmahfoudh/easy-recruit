package com.easyrecruit.management.service.impl;

import com.easyrecruit.dmn.infra.config.DmnConfiguration;
import com.easyrecruit.dmn.infra.config.DmnInitializer;
import com.easyrecruit.dmn.infra.model.StepModel;
import com.easyrecruit.management.infra.model.entity.Application;
import com.easyrecruit.management.infra.model.entity.Evaluation;
import com.easyrecruit.management.infra.model.entity.EvaluationStatus;
import com.easyrecruit.management.infra.model.entity.RecruitmentStep;
import com.easyrecruit.management.service.api.EvaluationModule;
import com.easyrecruit.management.service.api.ProcessModule;
import org.camunda.bpm.dmn.engine.DmnDecision;
import org.camunda.bpm.dmn.engine.DmnDecisionTableResult;
import org.camunda.bpm.dmn.engine.DmnEngine;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessModuleImpl implements ProcessModule {

    @Autowired
    private DmnInitializer dmnInitializer;
    @Autowired
    private DmnEngine dmnEngine;
    @Autowired
    private EvaluationModule evaluationModule;

    @Override
    public List<Evaluation> classifyAll() {
        dmnInitializer.initializeSteps();
        StepModel preliminaryStep = dmnInitializer.getSteps().get(0);
        List<Evaluation> evaluations = evaluationModule.getEvaluationsByStatusAndStep(EvaluationStatus.IDLE, RecruitmentStep.PRELIMINARY);
        List<Evaluation> classifiedEvaluations = evaluations.stream()
                .map(evaluation -> {
                    VariableMap variables = Variables
                            .putValue("score", evaluation.getScore());
                    DmnDecisionTableResult results = dmnEngine.evaluateDecisionTable((DmnDecision) preliminaryStep.getDecision(), variables);
                    String decision = (String) results.getSingleResult().get("status");
                    evaluation
                            .setStatus(EvaluationStatus.COMPLETED)
                            .setDecision(decision);
                    return evaluation;
                })
                .toList();
        classifiedEvaluations.forEach(evaluationModule::updateEvaluation);
        return classifiedEvaluations;
    }

    @Override
    public void classify(Application application) {

    }

    @Override
    public void classify(List<Application> applications) {

    }
}
