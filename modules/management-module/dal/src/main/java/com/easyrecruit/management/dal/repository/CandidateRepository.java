package com.easyrecruit.management.dal.repository;

import com.easyrecruit.management.dal.entity.CandidateEntity;
import com.easyrecruit.management.infra.model.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CandidateRepository extends JpaRepository<CandidateEntity, Long> {

    Optional<CandidateEntity> getCandidateEntityByUuid(String uuid);
    Optional<CandidateEntity> getCandidateEntityByEmail(String email);
    List<CandidateEntity> getCandidateEntityByFirstname(String firstname);
    List<CandidateEntity> getCandidateEntityByLastname(String lastname);
    List<CandidateEntity> getCandidateEntityByFirstnameAndLastname(String firstname, String lastname);
    void deleteCandidateEntityByUuid(String uuid);
    Boolean existsByEmail(String email);
}
