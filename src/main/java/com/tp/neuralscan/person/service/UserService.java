package com.tp.neuralscan.person.service;

import com.tp.neuralscan.person.model.UserEntity;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserEntity> getAllUsers();
    UserEntity createUser(UserEntity userEntity);
    UserEntity updateUser(Long id, UserEntity userEntity);
    UserEntity login(String email, String password);

    Optional<ResponseEntity<Object>> deleteUser(Long id);

}
