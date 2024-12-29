package com.easyrecruit.management.dal.repository;

import com.easyrecruit.management.dal.entity.InterviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InterviewRepository extends JpaRepository<InterviewEntity, Long> {

    Optional<InterviewEntity> getInterviewEntityByUuid(String uuid);
    List<InterviewEntity> getInterviewEntitiesByCandidate_Uuid(String candidateUuid);
    List<InterviewEntity> getInterviewEntitiesByRecruiterUuid(String recruiterUuid);
    List<InterviewEntity> getInterviewEntitiesByPositionUuid(String positionUuid);
    Optional<InterviewEntity> getInterviewEntityByPositionUuidAndCandidate_Uuid(String positionUuid, String candidateUuid);
    List<InterviewEntity> getInterviewEntitiesByPositionUuidAndRecruiterUuid(String positionUuid, String recruiterUuid);
    List<InterviewEntity> getInterviewEntitiesByCandidate_UuidAndRecruiterUuid(String candidateUuid, String recruiterUuid);
}
