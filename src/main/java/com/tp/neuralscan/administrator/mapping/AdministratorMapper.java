package com.tp.neuralscan.administrator.mapping;

import com.tp.neuralscan.administrator.dto.CreateAdministratorResource;
import com.tp.neuralscan.administrator.dto.AdministratorResource;
import com.tp.neuralscan.administrator.dto.UpdateAdministratorResource;
import com.tp.neuralscan.administrator.model.AdministratorEntity;
import com.tp.neuralscan.util.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class AdministratorMapper implements Serializable {

    @Autowired
    private EnhancedModelMapper modelMapper;

    public AdministratorResource toResource(AdministratorEntity administrator) {
        return modelMapper.map(administrator, AdministratorResource.class);
    }

    public List<AdministratorResource> toResource(List<AdministratorEntity> administrators) {
        return modelMapper.mapList(administrators, AdministratorResource.class);
    }

    public AdministratorEntity toEntity(CreateAdministratorResource administrator) {
        return modelMapper.map(administrator, AdministratorEntity.class);
    }

    public AdministratorEntity toEntity(UpdateAdministratorResource administrator) {
        return modelMapper.map(administrator, AdministratorEntity.class);
    }
}
