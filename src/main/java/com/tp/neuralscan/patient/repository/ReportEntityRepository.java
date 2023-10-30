package com.tp.neuralscan.patient.repository;

import com.tp.neuralscan.patient.model.ReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportEntityRepository extends JpaRepository<ReportEntity, Long> {
    ReportEntity findBySummary(String summary);
    ReportEntity findByDescription(String description);

}