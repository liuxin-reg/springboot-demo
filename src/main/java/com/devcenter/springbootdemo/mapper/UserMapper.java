package com.devcenter.springbootdemo.mapper;

import com.devcenter.springbootdemo.domain.User;

import java.util.List;

public interface UserMapper {
    List<User> findAll();

    // find a user by id
    User findById(Integer userId);

    // insert a new user, return affected rows (generated key will be populated on the parameter object)
    int save(User user);

    // update an existing user
    int update(User user);

    // delete by id
    int deleteById(Integer userId);
}
