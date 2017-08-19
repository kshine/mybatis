package com.freedom;

import com.freedom.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class App 
{
    public static void main( String[] args ) throws IOException {
        String resource = "mybatis.xml";
        InputStream inputSteam = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputSteam);
        SqlSession sqlSession =sqlSessionFactory.openSession();
//        findUserById(sqlSession,1);
        findUserByName(sqlSession,"小明");
        sqlSession.close();
    }

    public static User findUserById(SqlSession sqlSession,int i){
        User user = sqlSession.selectOne("test.findUserById",i);
        System.out.println(user);
        return user;
    }

    public static List<User> findUserByName(SqlSession sqlSession,String name){
        List<User> userList = sqlSession.selectList("test.findUserByName",name);
        System.out.println(userList);
        return userList;
    }
}
