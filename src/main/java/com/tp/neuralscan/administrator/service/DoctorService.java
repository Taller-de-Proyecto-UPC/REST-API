package com.tp.neuralscan.administrator.service;



import com.tp.neuralscan.administrator.model.DoctorEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface DoctorService {

    List<DoctorEntity> getAllDoctors();
    DoctorEntity createDoctor(DoctorEntity DoctorEntity, Long administratorId);
    DoctorEntity updateDoctor(Long id, DoctorEntity DoctorEntity);
    DoctorEntity loginDoctor(String email, String password);

    Optional<ResponseEntity<Object>> deleteDoctor(Long doctorId);

}
