package com.tp.neuralscan.patient.repository;

import com.tp.neuralscan.administrator.model.AdministratorEntity;
import com.tp.neuralscan.patient.model.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageEntityRepository extends JpaRepository<ImageEntity,Long> {
    ImageEntity findByPath(String path);

}
