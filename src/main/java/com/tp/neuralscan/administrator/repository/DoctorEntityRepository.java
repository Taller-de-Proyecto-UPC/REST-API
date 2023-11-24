package com.tp.neuralscan.administrator.repository;

import com.tp.neuralscan.administrator.model.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorEntityRepository extends JpaRepository<DoctorEntity, Long> {
    DoctorEntity findByCIP(String CIP);
    DoctorEntity findBySpecialty(String specialty);
}