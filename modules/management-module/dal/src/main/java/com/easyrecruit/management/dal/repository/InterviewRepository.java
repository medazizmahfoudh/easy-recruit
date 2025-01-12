package com.easyrecruit.management.dal.repository;

import com.easyrecruit.management.dal.entity.InterviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface InterviewRepository extends JpaRepository<InterviewEntity, Long> {

    Optional<InterviewEntity> getInterviewEntityByUuid(UUID uuid);
    List<InterviewEntity> getInterviewEntitiesByCandidate_Uuid(UUID candidateUuid);
    List<InterviewEntity> getInterviewEntitiesByRecruiterUuid(UUID recruiterUuid);
    List<InterviewEntity> getInterviewEntitiesByPositionUuid(String positionUuid);
    Optional<InterviewEntity> getInterviewEntityByPositionUuidAndCandidate_Uuid(String positionUuid, UUID candidateUuid);
    List<InterviewEntity> getInterviewEntitiesByPositionUuidAndRecruiterUuid(String positionUuid, UUID recruiterUuid);
    List<InterviewEntity> getInterviewEntitiesByCandidate_UuidAndRecruiterUuid(UUID candidateUuid, UUID recruiterUuid);
}
