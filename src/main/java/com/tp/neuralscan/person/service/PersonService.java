package com.tp.neuralscan.person.service;



import com.tp.neuralscan.person.model.PersonEntity;

import java.util.List;

public interface PersonService {

    List<PersonEntity> getAllPersons();
    PersonEntity createPerson(PersonEntity person);
    PersonEntity updatePerson(Long id, PersonEntity person);

}
