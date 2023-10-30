package com.tp.neuralscan.administrator.service;



import com.tp.neuralscan.administrator.model.DoctorEntity;

import java.util.List;

public interface DoctorService {

    List<DoctorEntity> getAllDoctors();
    DoctorEntity createDoctor(DoctorEntity DoctorEntity, Long administratorId);
    DoctorEntity updateDoctor(Long id, DoctorEntity DoctorEntity);
    DoctorEntity loginDoctor(String email, String password);

}
