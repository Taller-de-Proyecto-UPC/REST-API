package com.tp.neuralscan.person.service.impl;



import com.tp.neuralscan.person.model.UserEntity;
import com.tp.neuralscan.person.repository.UserEntityRepository;
import com.tp.neuralscan.person.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserEntityRepository userEntityRepository;

    @Override
    public List<UserEntity> getAllUsers() {
        return userEntityRepository.findAll();    }

    @Override
    public UserEntity createUser(UserEntity userEntity) {

        return userEntityRepository.save(userEntity);
    }

    @Override
    public UserEntity updateUser(Long id, UserEntity userEntity) {
        UserEntity user_updated = userEntityRepository.findById(id).orElseThrow();
        user_updated.setRole(userEntity.getRole());
        user_updated.setPassword(userEntity.getPassword());
        user_updated.setUsername(userEntity.getUsername());
        user_updated.setActive(userEntity.getActive());

        return userEntityRepository.save(user_updated);    }

    @Override
    public UserEntity login(String username, String password) {

        UserEntity userEntity = userEntityRepository.findByUsernameAndPassword(username, password);
        if (userEntity == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        System.out.println("Doctor info: ");

        return userEntity;
    }

    @Override
    public Optional<ResponseEntity<Object>> deleteUser(Long id) {
        return userEntityRepository.findById(id).map(user -> {
            userEntityRepository.delete(user);
            return ResponseEntity.ok().build();
        });
    }
}
