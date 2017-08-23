package com.freedom;


import com.freedom.mapper.UserMapper;
import com.freedom.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws Exception{
        String resource = "mybatis.xml";
        InputStream inputstream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputstream);

    }

    @Test
    public void testFindUserById()throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.findUserById(28);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void testFindUserByName()throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.findUserByName("小明");
        System.out.println(userList);
        sqlSession.close();
    }

    @Test
    public void testFindUserByHashMap() throws Exception{
        SqlSession sqlsession = sqlSessionFactory.openSession();
        HashMap<String,Object> userMap = new HashMap<String,Object>();
        userMap.put("id",28);
        userMap.put("username","大锤");
        UserMapper userMapper = sqlsession.getMapper(UserMapper.class);
        List<User> userList = userMapper.findUserByHashMap(userMap);
        System.out.println(userList);
        sqlsession.close();
    }

}
