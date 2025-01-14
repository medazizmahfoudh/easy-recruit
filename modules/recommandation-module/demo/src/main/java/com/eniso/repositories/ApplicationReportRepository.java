package com.eniso.repositories;

import com.eniso.entities.ApplicationReport;
import io.micronaut.data.jpa.repository.JpaRepository;

public interface ApplicationReportRepository extends JpaRepository<ApplicationReport, Long> {
}
