package com.tp.neuralscan.administrator.service.impl;

import com.tp.neuralscan.administrator.model.PersonEntity;
import com.tp.neuralscan.administrator.repository.PersonEntityRepository;
import com.tp.neuralscan.administrator.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService{

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
        PersonEntity personEntity = personEntityRepository.findById(id).orElseThrow();
        personEntity.setName(person.getName());
        personEntity.setLastName(person.getLastName());
        personEntity.setAddress(person.getAddress());
        personEntity.setPhone(person.getPhone());
        personEntity.setBirthday(person.getBirthday());
        return personEntityRepository.save(person);
    }

    @Override
    public Optional<ResponseEntity<Object>> deletePerson(Long id) {
        return personEntityRepository.findById(id).map(person -> {
            personEntityRepository.delete(person);
            return ResponseEntity.ok().build();
        });
    }
}
