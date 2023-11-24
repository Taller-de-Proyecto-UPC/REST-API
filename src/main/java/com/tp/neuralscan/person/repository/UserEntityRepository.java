package com.tp.neuralscan.person.repository;

import com.tp.neuralscan.person.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByUsernameAndPassword(String username, String password);

}