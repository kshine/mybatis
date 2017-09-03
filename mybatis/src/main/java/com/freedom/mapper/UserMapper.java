package com.freedom.mapper;

import com.freedom.po.User;
import com.freedom.po.UserCustom;
import com.freedom.po.UserQueryVo;

import java.util.HashMap;
import java.util.List;

public interface UserMapper {

    public List<UserCustom> findUserList(UserQueryVo userQueryVo) throws Exception;

    public int findUserCount(UserQueryVo userQueryVo) throws Exception;

    public User findUserByIdResultMap(int id) throws Exception;

    public User findUserById(int id) throws Exception;

    public List<User> findUserByName(String name) throws Exception;

    public void insertUser(User user) throws Exception;

    public void deleteUser(int id) throws Exception;

    public List<User> findUserByHashMap(HashMap<String,Object> hashMap) throws Exception;

    public void updateUser(User user) throws Exception;
}
