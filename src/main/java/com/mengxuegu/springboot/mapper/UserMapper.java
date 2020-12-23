package com.mengxuegu.springboot.mapper;

import com.mengxuegu.springboot.entities.User;

import java.util.List;

public interface UserMapper {
    List<User> getUsers(User user);

    User getUserById(Integer id);

    User loginUser(User user);

    int addUser(User user);

    int deleteUserById(Integer id);

    int updateUser(User user);
}
