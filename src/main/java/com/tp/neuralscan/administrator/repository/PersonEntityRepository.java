package com.tp.neuralscan.administrator.repository;

import com.tp.neuralscan.administrator.model.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonEntityRepository extends JpaRepository<PersonEntity,Long> {
    PersonEntity findById(int id);

}
