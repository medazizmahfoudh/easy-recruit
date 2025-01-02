package com.easyrecruit.management.service.impl.converter;

import com.easyrecruit.management.dal.entity.EvaluationEntity;
import com.easyrecruit.management.infra.model.entity.Evaluation;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-02T01:02:07+0100",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.13 (Ubuntu)"
)
public class EvaluationConverterImpl implements EvaluationConverter {

    @Override
    public EvaluationEntity toEntity(Evaluation evaluation) {
        if ( evaluation == null ) {
            return null;
        }

        EvaluationEntity evaluationEntity = new EvaluationEntity();

        evaluationEntity.setId( evaluation.getId() );
        evaluationEntity.setUuid( evaluation.getUuid() );
        evaluationEntity.setApplicationUuid( evaluation.getApplicationUuid() );
        evaluationEntity.setStep( evaluation.getStep() );
        evaluationEntity.setScore( evaluation.getScore() );
        evaluationEntity.setDecision( evaluation.getDecision() );
        evaluationEntity.setStatus( evaluation.getStatus() );

        return evaluationEntity;
    }

    @Override
    public Evaluation fromEntity(EvaluationEntity evaluationEntity) {
        if ( evaluationEntity == null ) {
            return null;
        }

        Evaluation evaluation = new Evaluation();

        evaluation.setId( evaluationEntity.getId() );
        evaluation.setUuid( evaluationEntity.getUuid() );
        evaluation.setApplicationUuid( evaluationEntity.getApplicationUuid() );
        evaluation.setStep( evaluationEntity.getStep() );
        evaluation.setScore( evaluationEntity.getScore() );
        evaluation.setDecision( evaluationEntity.getDecision() );
        evaluation.setStatus( evaluationEntity.getStatus() );

        return evaluation;
    }
}
