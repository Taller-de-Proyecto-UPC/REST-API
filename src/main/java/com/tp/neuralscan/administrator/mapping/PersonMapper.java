package com.tp.neuralscan.administrator.mapping;

import com.tp.neuralscan.administrator.dto.CreatePersonResource;
import com.tp.neuralscan.administrator.dto.PersonResource;
import com.tp.neuralscan.administrator.dto.UpdatePersonResource;
import com.tp.neuralscan.administrator.model.PersonEntity;
import com.tp.neuralscan.util.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class PersonMapper implements Serializable {

    @Autowired
    private EnhancedModelMapper modelMapper;

    public PersonResource toResource(PersonEntity person) {
        return modelMapper.map(person, PersonResource.class);
    }

    public List<PersonResource> toResource(List<PersonEntity> persons) {
        return modelMapper.mapList(persons, PersonResource.class);
    }

    public PersonEntity toEntity(CreatePersonResource person) {
        return modelMapper.map(person, PersonEntity.class);
    }

    public PersonEntity toEntity(UpdatePersonResource person) {
        return modelMapper.map(person, PersonEntity.class);
    }

}
