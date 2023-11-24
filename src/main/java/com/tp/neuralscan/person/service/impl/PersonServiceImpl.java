package com.tp.neuralscan.person.service.impl;


import com.tp.neuralscan.person.model.PersonEntity;
import com.tp.neuralscan.person.repository.PersonEntityRepository;
import com.tp.neuralscan.person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonEntityRepository personEntityRepository;

    @Override
    public List<PersonEntity> getAllPersons() {
        return personEntityRepository.findAll();
    }

    @Override
    public PersonEntity createPerson(PersonEntity person) {
        return personEntityRepository.save(person);
    }

    @Override
    public PersonEntity updatePerson(Long id, PersonEntity person) {
        PersonEntity person_updated = personEntityRepository.findById(id).orElseThrow();
        person_updated.setName(person.getName());
        person_updated.setLastName(person.getLastName());
        person_updated.setEmail(person.getEmail());
        person_updated.setPhone(person.getPhone());
        person_updated.setAddress(person.getAddress());

        return personEntityRepository.save(person_updated);
    }

}
