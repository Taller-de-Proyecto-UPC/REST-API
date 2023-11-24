package com.tp.neuralscan.administrator.service.impl;


import com.tp.neuralscan.administrator.model.DoctorEntity;
import com.tp.neuralscan.administrator.repository.DoctorEntityRepository;
import com.tp.neuralscan.administrator.service.DoctorService;
import com.tp.neuralscan.person.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorEntityRepository doctorEntityRepository;

    @Autowired
    private UserEntityRepository userEntityRepository;


    @Override
    public List<DoctorEntity> getAllDoctors() {
        return doctorEntityRepository.findAll();
    }

    @Override
    public DoctorEntity createDoctor(DoctorEntity doctorEntity) {
        //doctorEntity.setUserEntity(userEntityRepository.findById(userId).orElse(null));
        return doctorEntityRepository.save(doctorEntity);
    }

    @Override
    public DoctorEntity updateDoctor(Long id, DoctorEntity doctorEntity) {
        DoctorEntity doctor = doctorEntityRepository.findById(id).orElseThrow();
        doctor.setName(doctorEntity.getName());
        doctor.setLastName(doctorEntity.getLastName());
        doctor.setEmail(doctorEntity.getEmail());
        doctor.setPhone(doctorEntity.getPhone());
        doctor.setAddress(doctorEntity.getAddress());
        doctor.setBirthday(doctorEntity.getBirthday());
        doctor.setSpecialty(doctorEntity.getSpecialty());
        doctor.setCIP(doctorEntity.getCIP());
        //doctorEntity.setUserEntity(doctor.getUserEntity());
        return doctorEntityRepository.save(doctor);
    }

    @Override
    public Optional<ResponseEntity<Object>> deleteDoctor(Long doctorId) {
        return doctorEntityRepository.findById(doctorId).map(doctor -> {
            doctorEntityRepository.delete(doctor);
                return ResponseEntity.ok().build();
            });
    }
}
