package com.tp.neuralscan.patient.service.impl;


import com.tp.neuralscan.doctor.repository.DoctorEntityRepository;
import com.tp.neuralscan.patient.model.PatientEntity;
import com.tp.neuralscan.patient.repository.PatientEntityRepository;
import com.tp.neuralscan.patient.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientEntityRepository patientEntityRepository;

    @Autowired
    private DoctorEntityRepository doctorEntityRepository;


    @Override
    public List<PatientEntity> getAllPatients() {
        return patientEntityRepository.findAll();
    }

    @Override
    public PatientEntity createPatient(PatientEntity patientEntity, Long doctorId) {
        patientEntity.setDoctorEntity(doctorEntityRepository.findById(doctorId).orElse(null));
        return patientEntityRepository.save(patientEntity);
    }

    @Override
    public PatientEntity updatePatient(Long id, PatientEntity patientEntity) {
        PatientEntity patient = patientEntityRepository.findById(id).orElseThrow();
        patient.setName(patientEntity.getName());
        patient.setLastName(patientEntity.getLastName());
        patient.setEmail(patientEntity.getEmail());
        patient.setPhone(patientEntity.getPhone());
        patient.setAddress(patientEntity.getAddress());
        patient.setBirthday(patientEntity.getBirthday());
        patient.setBloodType(patientEntity.getBloodType());
        patient.setDiseases(patientEntity.getDiseases());
        patient.setWeight(patientEntity.getWeight());
        patient.setHeight(patientEntity.getHeight());

        return patientEntityRepository.save(patient);
    }

    @Override
    public PatientEntity getPatientByDni(String dni) {
        if(patientEntityRepository.findByDni(dni) != null)
            return patientEntityRepository.findByDni(dni);
        else
            return null;
    }

    @Override
    public Optional<ResponseEntity<Object>> deletePatient(Long patientId) {
        return patientEntityRepository.findById(patientId).map(patient -> {
            patientEntityRepository.delete(patient);
            return ResponseEntity.ok().build();
        });
    }

}
