package com.easyrecruit.management.service.impl;

import com.easyrecruit.management.dal.entity.EvaluationEntity;
import com.easyrecruit.management.dal.repository.EvaluationRepository;
import com.easyrecruit.management.infra.model.entity.Evaluation;
import com.easyrecruit.management.infra.model.entity.EvaluationStatus;
import com.easyrecruit.management.infra.model.entity.RecruitmentStep;
import com.easyrecruit.management.infra.model.payload.response.DeleteResponse;
import com.easyrecruit.management.infra.model.payload.response.OperationStatus;
import com.easyrecruit.management.service.api.EvaluationModule;
import com.easyrecruit.management.service.api.exception.CRUDOperation;
import com.easyrecruit.management.service.api.exception.CRUDOperationException;
import com.easyrecruit.management.service.impl.converter.EvaluationConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EvaluationModuleImpl implements EvaluationModule {

    @Autowired
    private EvaluationRepository repository;

    @Override
    public void createEvaluation(Evaluation evaluation) {
        repository.save(EvaluationConverter.INSTANCE.toEntity(evaluation));
    }

    @Override
    public void createInterviewEvaluation() {
        repository.save(EvaluationConverter.INSTANCE.toEntity(new Evaluation().setStep(RecruitmentStep.INTERVIEW)));
    }

    @Override
    public void updateEvaluation(Evaluation evaluation) {
        repository.save(EvaluationConverter.INSTANCE.toEntity(evaluation));
    }

    @Override
    public Evaluation updateEvaluationScore(String uuid, Double score) {
        Optional<EvaluationEntity> evaluationEntity = repository.findByUuid(uuid);
        if (evaluationEntity.isEmpty()) {
            throw new CRUDOperationException(CRUDOperation.READ, "Evaluation not found");
        }
        Evaluation evaluation = EvaluationConverter.INSTANCE.fromEntity(evaluationEntity.get());
        evaluation.setScore(score);
        repository.save(EvaluationConverter.INSTANCE.toEntity(evaluation));
        return evaluation;
    }

    @Override
    public DeleteResponse deleteEvaluation(String uuid) {
        repository.deleteByUuid(uuid);
        return new DeleteResponse(OperationStatus.SUCCESS, "Resource has been successfully deleted");

    }

    @Override
    public List<Evaluation> getAllEvaluations() {
        return repository.findAll()
                .stream()
                .map(EvaluationConverter.INSTANCE::fromEntity)
                .toList();
    }

    @Override
    public Evaluation getEvaluation(String uuid) {
        Optional<EvaluationEntity> evaluationEntity = repository.findByUuid(uuid);
        if (evaluationEntity.isEmpty()) {
            throw new CRUDOperationException(CRUDOperation.READ, "Evaluation for the given uuid does not exist");
        }
        return EvaluationConverter.INSTANCE.fromEntity(evaluationEntity.get());
    }

    @Override
    public List<Evaluation> getEvaluationsByApplicationUuid(String applicationUuid) {
        return repository.findEvaluationEntitiesByApplicationUuid(applicationUuid)
                .stream()
                .map(EvaluationConverter.INSTANCE::fromEntity)
                .toList();
    }

    @Override
    public List<Evaluation> getEvaluationsByStatusAndStep(EvaluationStatus status, RecruitmentStep step) {
        List<EvaluationEntity> evaluationEntities = repository.getEvaluationEntitiesByStatusAndStep(status, step);
        return evaluationEntities
                .stream()
                .map(EvaluationConverter.INSTANCE::fromEntity)
                .toList();
    }

    @Override
    public Evaluation getEvaluationByApplicationUuidAndStepIsPreliminary(String applicationUuid) {
        return null;
    }

    @Override
    public Evaluation updateEvaluationScoreByApplicationUuidAndStatusIsNew(String applicationUuid, Double score, String feedback) {
        return null;
    }
}
