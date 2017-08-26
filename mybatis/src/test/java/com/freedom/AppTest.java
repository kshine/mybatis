package com.freedom;


import com.freedom.mapper.UserMapper;
import com.freedom.po.User;
import com.freedom.po.UserCustom;
import com.freedom.po.UserQueryVo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
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

    @Test
    public void testFindUserList() throws Exception {
        SqlSession sqlsession = sqlSessionFactory.openSession();
        UserCustom userCustom = new UserCustom();
        userCustom.setSex("1");
        userCustom.setUserName("小明");
        UserQueryVo userQueryVo = new UserQueryVo();
        userQueryVo.setUserCustom(userCustom);
        UserMapper userMapper = sqlsession.getMapper(UserMapper.class);
        List<UserCustom> userCustomList = userMapper.findUserList(userQueryVo);
        System.out.println(userCustomList);
        sqlsession.close();
    }

    @Test
    public void testFindUserCount() throws Exception {
        SqlSession sqlsession = sqlSessionFactory.openSession();
        UserCustom userCustom = new UserCustom();
        userCustom.setSex("1");
//        userCustom.setUserName("小明");
        UserQueryVo userQueryVo = new UserQueryVo();
        userQueryVo.setUserCustom(userCustom);

        List<Integer> idList = new ArrayList<Integer>();
        idList.add(10);
        idList.add(28);
        userQueryVo.setIds(idList);

        UserMapper userMapper = sqlsession.getMapper(UserMapper.class);
        int userCount = userMapper.findUserCount(userQueryVo);
        System.out.println(userCount);
        sqlsession.close();
    }

    @Test
    public void testFindUserByIdResultMap() throws Exception {
        SqlSession sqlsession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlsession.getMapper(UserMapper.class);
        User user = userMapper.findUserByIdResultMap(28);
        System.out.println(user);
        sqlsession.close();
    }
}
