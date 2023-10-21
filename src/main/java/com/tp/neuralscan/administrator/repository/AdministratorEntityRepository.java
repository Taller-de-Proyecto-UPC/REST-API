package com.tp.neuralscan.administrator.repository;

import com.tp.neuralscan.administrator.model.AdministratorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministratorEntityRepository extends JpaRepository<AdministratorEntity, Long> {
    AdministratorEntity findByEmail(String email);
    AdministratorEntity findByEmailAndPassword(String email, String password);

}