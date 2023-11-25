package com.tp.neuralscan.administrator.service;



import com.tp.neuralscan.administrator.model.DoctorEntity;
import com.tp.neuralscan.person.model.UserEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface DoctorService {

    List<DoctorEntity> getAllDoctors();
    DoctorEntity createDoctor(DoctorEntity DoctorEntity, UserEntity userEntity);
    DoctorEntity updateDoctor(Long id, DoctorEntity DoctorEntity);

    DoctorEntity findByUsername(String username);
    Optional<ResponseEntity<Object>> deleteDoctor(Long doctorId);

}
