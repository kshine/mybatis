package com.freedom;

import com.freedom.dao.UserDao;
import com.freedom.dao.UserDaoImpl;
import com.freedom.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;


public class App 
{
    public static void main( String[] args ) throws Exception {
        String resource = "mybatis.xml";
        InputStream inputSteam = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputSteam);
        SqlSession sqlSession =sqlSessionFactory.openSession();

        UserDao userDao = new UserDaoImpl(sqlSessionFactory);
        User user =userDao.findUserById(1);
        System.out.println(user);

//        findUserById(sqlSession,1);

//        findUserByName(sqlSession,"小明");

//        User user = new User();
//        user.setUserName("王大锤");
//        user.setBirthday(new SimpleDateFormat("yyyyMMdd").parse("19990909"));
//        user.setSex("1");
//        user.setAddress("艾泽拉斯");
//        insertUser(sqlSession,user);

//        deleteUser(sqlSession,29);

//       User user = findUserById(sqlSession,28);
//       user.setAddress("崔斯特姆");
//       updateUser(sqlSession,user);

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

    public static void insertUser(SqlSession sqlsession,User user){
        sqlsession.insert("test.insertUser",user);
        sqlsession.commit();
        System.out.println(user.getId());
    }

    public static void deleteUser(SqlSession sqlSession,int id){
        sqlSession.delete("test.deleteUserById",id);
        sqlSession.commit();
    }

    public static void updateUser(SqlSession sqlSession,User user){
        sqlSession.update("test.updateUser",user);
        sqlSession.commit();
    }
}
