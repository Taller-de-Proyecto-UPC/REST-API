package com.tp.neuralscan.patient.service;



import com.tp.neuralscan.patient.model.PatientEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface PatientService {

    List<PatientEntity> getAllPatients();
    PatientEntity createPatient(PatientEntity Patient, Long doctorId);
    PatientEntity updatePatient(Long id, PatientEntity Patient);

    PatientEntity getPatientByDni(String dni);
    Optional<ResponseEntity<Object>> deletePatient(Long patientId);

}
