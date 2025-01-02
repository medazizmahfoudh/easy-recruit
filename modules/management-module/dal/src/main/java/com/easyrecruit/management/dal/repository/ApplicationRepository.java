package com.easyrecruit.management.dal.repository;

import com.easyrecruit.management.dal.entity.ApplicationEntity;
import com.easyrecruit.management.infra.model.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApplicationRepository extends JpaRepository<ApplicationEntity, Long>, JpaSpecificationExecutor<ApplicationEntity> {

    Optional<ApplicationEntity> getApplicationEntityByUuid(String uuid);
    Optional<ApplicationEntity> getApplicationEntityByCandidate_UuidAndPositionUuid(String candidateUuid, String positionUuid);
    List<ApplicationEntity> getApplicationEntitiesByCandidate(Candidate candidate);
    List<ApplicationEntity> getApplicationEntitiesByCandidate_Uuid(String candidateUuid);
    List<ApplicationEntity> getApplicationEntitiesByCandidate_Firstname(String firstname);
    List<ApplicationEntity> getApplicationEntitiesByCandidate_Lastname(String lastname);
    List<ApplicationEntity> getApplicationEntitiesByCandidate_FirstnameAndCandidate_Lastname(String firstname, String lastname);
    List<ApplicationEntity> getApplicationEntitiesByPositionUuid(String positionUuid);
    void deleteApplicationEntityById(Long id);
    void deleteApplicationEntityByUuid(String uuid);
    void deleteApplicationEntityByIdOrUuid(Long id, String uuid);
    Boolean existsByCandidate_UuidAndPositionUuid(String candidateUuid, String positionUuid);
}
