package com.tp.neuralscan.administrator.service;

import com.tp.neuralscan.administrator.model.PersonEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface PersonService {

    List<PersonEntity> getAllPersons();
    PersonEntity createPerson(PersonEntity person);
    PersonEntity updatePerson(Long id, PersonEntity person);
    Optional<ResponseEntity<Object>> deletePerson(Long id);


}
