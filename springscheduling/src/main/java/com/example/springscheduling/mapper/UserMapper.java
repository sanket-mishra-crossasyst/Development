package com.example.springscheduling.mapper;

import com.example.springscheduling.entity.UserEntity;
import com.example.springscheduling.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface UserMapper {
    User  entityToUser(UserEntity userEntity);
    UserEntity userToEntity(User user);
}
