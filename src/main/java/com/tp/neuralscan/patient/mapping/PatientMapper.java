package com.tp.neuralscan.patient.mapping;


import com.tp.neuralscan.patient.dto.PatientResource;
import com.tp.neuralscan.patient.dto.CreatePatientResource;
import com.tp.neuralscan.patient.dto.UpdatePatientResource;
import com.tp.neuralscan.patient.model.PatientEntity;
import com.tp.neuralscan.util.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class PatientMapper implements Serializable {

    @Autowired
    private EnhancedModelMapper modelMapper;

    public PatientResource toResource(PatientEntity patient) {
        return modelMapper.map(patient, PatientResource.class);
    }

    public List<PatientResource> toResource(List<PatientEntity> patients) {
        return modelMapper.mapList(patients, PatientResource.class);
    }

    public PatientEntity toEntity(CreatePatientResource patient) {
        return modelMapper.map(patient, PatientEntity.class);
    }

    public PatientEntity toEntity(UpdatePatientResource patient) {
        return modelMapper.map(patient, PatientEntity.class);
    }
}
