package com.freedom.mapper;

import com.freedom.po.User;

import java.util.List;

public interface UserMapper {

    public User findUserById(int id) throws Exception;

    public List<User> findUserByName(String name) throws Exception;

    public void insertUser(User user) throws Exception;

    public void deleteUser(int id) throws Exception;
}
