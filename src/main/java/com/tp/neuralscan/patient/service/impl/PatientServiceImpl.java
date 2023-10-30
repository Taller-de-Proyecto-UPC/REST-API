package com.tp.neuralscan.patient.service.impl;


import com.tp.neuralscan.patient.model.PatientEntity;
import com.tp.neuralscan.patient.repository.PatientEntityRepository;
import com.tp.neuralscan.patient.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientEntityRepository patientEntityRepository;

    @Override
    public List<PatientEntity> getAllPatients() {
        return patientEntityRepository.findAll();
    }

    @Override
    public PatientEntity createPatient(PatientEntity patientEntity) {
        return patientEntityRepository.save(patientEntity);
    }

    @Override
    public PatientEntity updatePatient(Long id, PatientEntity patientEntity) {
        PatientEntity patient = patientEntityRepository.findById(id).orElseThrow();
        patient.setName(patientEntity.getName());
        patient.setLastName(patientEntity.getLastName());
        patient.setEmail(patientEntity.getEmail());
        return patientEntityRepository.save(patientEntity);
    }

}
