package com.example.demo.service;

import com.example.demo.entity.UserEntity;

public interface UserService {

    UserEntity addUser(UserEntity userEntity);

    UserEntity findById(long id);

    void deleteUser(Long id);

    UserEntity updateUser(Long id, UserEntity userEntity);
}
