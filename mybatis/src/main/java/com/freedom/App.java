package com.freedom;

import com.freedom.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        String resource = "mybatis.xml";
        InputStream inputSteam = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputSteam);
        SqlSession sqlseesion =sqlSessionFactory.openSession();
        User user = sqlseesion.selectOne("findUserById",1);
        System.out.println(user);
    }
}
