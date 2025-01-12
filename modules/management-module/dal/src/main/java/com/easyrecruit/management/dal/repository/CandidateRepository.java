package com.easyrecruit.management.dal.repository;

import com.easyrecruit.management.dal.entity.CandidateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CandidateRepository extends JpaRepository<CandidateEntity, Long> {

    Optional<CandidateEntity> getCandidateEntityByUuid(UUID uuid);
    Optional<CandidateEntity> getCandidateEntityByEmail(String email);
    List<CandidateEntity> getCandidateEntityByFirstname(String firstname);
    List<CandidateEntity> getCandidateEntityByLastname(String lastname);
    List<CandidateEntity> getCandidateEntityByFirstnameAndLastname(String firstname, String lastname);
    void deleteCandidateEntityByUuid(UUID uuid);
    Boolean existsByEmail(String email);
}
