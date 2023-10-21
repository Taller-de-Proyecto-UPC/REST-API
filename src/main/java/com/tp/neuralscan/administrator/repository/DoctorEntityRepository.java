package com.tp.neuralscan.administrator.repository;

import com.tp.neuralscan.administrator.model.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DoctorEntityRepository extends JpaRepository<DoctorEntity, Long> {
    DoctorEntity findByEmail(String email);
    DoctorEntity findByEmailAndPassword(String email, String password);

}