package com.easyrecruit.management.dal.repository;

import com.easyrecruit.management.dal.entity.EvaluationEntity;
import com.easyrecruit.management.infra.model.entity.EvaluationStatus;
import com.easyrecruit.management.infra.model.entity.RecruitmentStep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EvaluationRepository extends JpaRepository<EvaluationEntity, Integer> {

    Optional<EvaluationEntity> findByUuid(String uuid);
    List<EvaluationEntity> findEvaluationEntitiesByApplicationUuid(String applicationUuid);
    void deleteByUuid(String uuid);
    List<EvaluationEntity> getEvaluationEntitiesByStatusAndStep(EvaluationStatus status, RecruitmentStep step);
}
