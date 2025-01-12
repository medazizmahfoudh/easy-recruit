package com.easyrecruit.management.dal.repository;

import com.easyrecruit.management.dal.entity.RecruiterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface RecruiterRepository extends JpaRepository<RecruiterEntity, Long> {

    Optional<RecruiterEntity> getRecruiterEntityById(Long id);
    Optional<RecruiterEntity> getRecruiterEntityByUuid(UUID uuid);
    List<RecruiterEntity> getRecruiterEntityByDepartment(String department);
    List<RecruiterEntity> getRecruiterEntityByTitle(String title);
    List<RecruiterEntity> getRecruiterEntityByFirstname(String firstname);
    List<RecruiterEntity> getRecruiterEntityByLastname(String lastname);
    List<RecruiterEntity> getRecruiterEntityByFirstnameAndLastname(String firstname, String lastname);
    void deleteRecruiterEntityById(Long id);
    void deleteRecruiterEntityByUuid(UUID uuid);
}
