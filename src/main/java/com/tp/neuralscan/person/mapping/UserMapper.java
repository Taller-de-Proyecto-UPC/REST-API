package com.tp.neuralscan.person.mapping;



import com.tp.neuralscan.person.dto.CreateUserResource;
import com.tp.neuralscan.person.dto.UpdateUserResource;
import com.tp.neuralscan.person.dto.UserResource;
import com.tp.neuralscan.person.model.UserEntity;
import com.tp.neuralscan.util.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class UserMapper implements Serializable {

    @Autowired
    private EnhancedModelMapper modelMapper;

    public UserResource toResource(UserEntity user) {
        return modelMapper.map(user, UserResource.class);
    }

    public List<UserResource> toResource(List<UserEntity> users) {
        return modelMapper.mapList(users, UserResource.class);
    }

    public UserEntity toEntity(CreateUserResource user) {
        return modelMapper.map(user, UserEntity.class);
    }

    public UserEntity toEntity(UpdateUserResource user) {
        return modelMapper.map(user, UserEntity.class);
    }
}
