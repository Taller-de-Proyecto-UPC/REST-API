package com.tp.neuralscan.person.repository;

import com.tp.neuralscan.person.model.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonEntityRepository extends JpaRepository<PersonEntity, Long> {
    PersonEntity findByEmail(String email);
}