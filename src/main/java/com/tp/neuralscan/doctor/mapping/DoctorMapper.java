package com.tp.neuralscan.doctor.mapping;


import com.tp.neuralscan.doctor.dto.CreateDoctorResource;
import com.tp.neuralscan.doctor.dto.DoctorResource;
import com.tp.neuralscan.doctor.dto.UpdateDoctorResource;
import com.tp.neuralscan.doctor.model.DoctorEntity;
import com.tp.neuralscan.util.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class DoctorMapper implements Serializable {

    @Autowired
    private EnhancedModelMapper modelMapper;

    public DoctorResource toResource(DoctorEntity doctor) {
        return modelMapper.map(doctor, DoctorResource.class);
    }

    public List<DoctorResource> toResource(List<DoctorEntity> administrators) {
        return modelMapper.mapList(administrators, DoctorResource.class);
    }

    public DoctorEntity toEntity(CreateDoctorResource administrator) {
        return modelMapper.map(administrator, DoctorEntity.class);
    }

    public DoctorEntity toEntity(UpdateDoctorResource administrator) {
        return modelMapper.map(administrator, DoctorEntity.class);
    }
}
