package com.freedom.dao;

import com.freedom.po.User;

public interface UserDao {

    public User findUserById(int id) throws Exception;

    public void insertUser(User user) throws Exception;

    public void deleteUser(int id) throws Exception;
}
