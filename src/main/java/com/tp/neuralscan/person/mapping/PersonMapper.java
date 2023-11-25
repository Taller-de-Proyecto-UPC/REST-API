package com.tp.neuralscan.person.mapping;


import com.tp.neuralscan.person.dto.*;
import com.tp.neuralscan.person.model.PersonEntity;
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
