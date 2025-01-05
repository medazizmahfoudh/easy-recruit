package com.easyrecruit.management.service.api;


import com.easyrecruit.management.infra.model.entity.Evaluation;
import com.easyrecruit.management.infra.model.entity.EvaluationStatus;
import com.easyrecruit.management.infra.model.entity.RecruitmentStep;
import com.easyrecruit.management.infra.model.payload.response.DeleteResponse;

import java.util.List;

public interface EvaluationModule {

    void createEvaluation(Evaluation evaluation);
    void createInterviewEvaluation();
    void updateEvaluation(Evaluation evaluation);
    Evaluation updateEvaluationScore(String uuid, Double score);
    DeleteResponse deleteEvaluation(String uuid);
    List<Evaluation> getAllEvaluations();
    Evaluation getEvaluation(String uuid);
    List<Evaluation> getEvaluationsByApplicationUuid(String applicationUuid);
    List<Evaluation> getEvaluationsByStatusAndStep(EvaluationStatus status, RecruitmentStep step);

    // For evaluation module
    Evaluation getEvaluationByApplicationUuidAndStepIsPreliminary(String applicationUuid);
    Evaluation updateEvaluationScoreByApplicationUuidAndStatusIsNew(String applicationUuid, Double score, String feedback);

}
