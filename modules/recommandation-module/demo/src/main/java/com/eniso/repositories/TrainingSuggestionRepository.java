package com.eniso.repositories;

import com.eniso.entities.ApplicationReport;
import io.micronaut.data.jpa.repository.JpaRepository;

public interface TrainingSuggestionRepository extends JpaRepository<ApplicationReport, Long> {
}
