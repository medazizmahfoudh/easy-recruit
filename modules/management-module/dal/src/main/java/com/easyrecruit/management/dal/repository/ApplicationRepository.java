package com.easyrecruit.management.dal.repository;

import com.easyrecruit.management.dal.entity.ApplicationEntity;
import com.easyrecruit.management.dal.entity.CandidateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ApplicationRepository extends JpaRepository<ApplicationEntity, Long> {

    Optional<ApplicationEntity> getApplicationEntityByUuid(UUID uuid);
    Optional<ApplicationEntity> getApplicationEntityByCandidate_UuidAndPositionUuid(UUID candidateUuid, String positionUuid);
    List<ApplicationEntity> getApplicationEntitiesByCandidate(CandidateEntity candidate);
    List<ApplicationEntity> getApplicationEntitiesByCandidate_Uuid(UUID candidateUuid);
    List<ApplicationEntity> getApplicationEntitiesByCandidate_Firstname(String firstname);
    List<ApplicationEntity> getApplicationEntitiesByCandidate_Lastname(String lastname);
    List<ApplicationEntity> getApplicationEntitiesByCandidate_FirstnameAndCandidate_Lastname(String firstname, String lastname);
    List<ApplicationEntity> getApplicationEntitiesByPositionUuid(String positionUuid);
    void deleteApplicationEntityById(Long id);
    void deleteApplicationEntityByUuid(UUID uuid);
    void deleteApplicationEntityByIdOrUuid(Long id, UUID uuid);
    Boolean existsByCandidate_UuidAndPositionUuid(UUID candidateUuid, String positionUuid);
}
