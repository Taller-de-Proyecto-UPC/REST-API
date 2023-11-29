package com.tp.neuralscan.patient.repository;

import com.tp.neuralscan.patient.model.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientEntityRepository extends JpaRepository<PatientEntity, Long> {
    PatientEntity findByDni(String dni);
}