package com.tp.neuralscan.administrator.service.impl;


import com.tp.neuralscan.administrator.model.DoctorEntity;
import com.tp.neuralscan.administrator.repository.AdministratorEntityRepository;
import com.tp.neuralscan.administrator.repository.DoctorEntityRepository;
import com.tp.neuralscan.administrator.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;


@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorEntityRepository doctorEntityRepository;
    @Autowired
    private AdministratorEntityRepository administratorEntityRepository;

    @Override
    public List<DoctorEntity> getAllDoctors() {
        return doctorEntityRepository.findAll();
    }

    @Override
    public DoctorEntity createDoctor(DoctorEntity doctorEntity, Long administratorId) {
        doctorEntity.setAdministratorEntity(administratorEntityRepository.findById(administratorId).orElse(null));
        return doctorEntityRepository.save(doctorEntity);
    }

    @Override
    public DoctorEntity updateDoctor(Long id, DoctorEntity doctorEntity) {
        DoctorEntity doctor = doctorEntityRepository.findById(id).orElseThrow();
        doctor.setName(doctorEntity.getName());
        doctor.setLastName(doctorEntity.getLastName());
        doctor.setEmail(doctorEntity.getEmail());
        doctor.setPassword(doctorEntity.getPassword());
        doctorEntity.setAdministratorEntity(doctor.getAdministratorEntity());

        return doctorEntityRepository.save(doctor);
    }

    @Override
    public DoctorEntity loginDoctor(String email, String password) {
        DoctorEntity doctorEntity = doctorEntityRepository.findByEmailAndPassword(email, password);
        if (doctorEntity == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Doctor not found");
        return doctorEntity;
    }

    @Override
    public Optional<ResponseEntity<Object>> deleteDoctor(Long doctorId) {
        return doctorEntityRepository.findById(doctorId).map(doctor -> {
            doctorEntityRepository.delete(doctor);
                return ResponseEntity.ok().build();
            });
    }
}
