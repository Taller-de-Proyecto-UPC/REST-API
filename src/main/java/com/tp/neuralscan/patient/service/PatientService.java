package com.tp.neuralscan.patient.service;



import com.tp.neuralscan.patient.model.PatientEntity;

import java.util.List;

public interface PatientService {

    List<PatientEntity> getAllPatients();
    PatientEntity createPatient(PatientEntity Patient, Long doctorId);
    PatientEntity updatePatient(Long id, PatientEntity Patient);
}
