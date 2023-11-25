package com.tp.neuralscan.doctor.repository;

import com.tp.neuralscan.doctor.model.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorEntityRepository extends JpaRepository<DoctorEntity, Long> {
    DoctorEntity findByCIP(String CIP);
    DoctorEntity findBySpecialty(String specialty);

    DoctorEntity findByUserEntityUsername(String username);

}