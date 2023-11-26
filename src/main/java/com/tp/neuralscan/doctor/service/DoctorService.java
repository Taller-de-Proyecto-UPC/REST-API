package com.tp.neuralscan.doctor.service;



import com.tp.neuralscan.doctor.model.DoctorEntity;
import com.tp.neuralscan.person.model.UserEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface DoctorService {

    List<DoctorEntity> getAllDoctors();
    DoctorEntity createDoctor(DoctorEntity DoctorEntity, UserEntity userEntity);
    DoctorEntity updateDoctor(Long id, DoctorEntity DoctorEntity, String username);

    DoctorEntity findByUsername(String username);
    Optional<ResponseEntity<Object>> deleteDoctor(Long doctorId);

}