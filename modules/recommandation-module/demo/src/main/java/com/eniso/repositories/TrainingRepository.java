package com.eniso.repositories;

import com.eniso.entities.Training;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.mongodb.annotation.MongoRepository;
import io.micronaut.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TrainingRepository extends JpaRepository<Training, Integer>, JpaSpecificationExecutor<Training> {
}
