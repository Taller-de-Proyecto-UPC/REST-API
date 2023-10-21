package com.tp.neuralscan.administrator.service.impl;


import com.tp.neuralscan.administrator.model.DoctorEntity;
import com.tp.neuralscan.administrator.repository.DoctorEntityRepository;
import com.tp.neuralscan.administrator.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorEntityRepository doctorEntityRepository;

    @Override
    public List<DoctorEntity> getAllDoctors() {
        return doctorEntityRepository.findAll();
    }

    @Override
    public DoctorEntity createDoctor(DoctorEntity doctorEntity) {
        return doctorEntityRepository.save(doctorEntity);
    }

    @Override
    public DoctorEntity updateDoctor(Long id, DoctorEntity doctorEntity) {
        DoctorEntity doctor = doctorEntityRepository.findById(id).orElseThrow();
        doctor.setName(doctorEntity.getName());
        doctor.setLastName(doctorEntity.getLastName());
        doctor.setEmail(doctorEntity.getEmail());
        return doctorEntityRepository.save(doctorEntity);
    }

    @Override
    public DoctorEntity loginDoctor(String email, String password) {
        DoctorEntity doctorEntity = doctorEntityRepository.findByEmailAndPassword(email, password);
        if (doctorEntity == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Doctor not found");
        return doctorEntity;
    }
}
