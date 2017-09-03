package com.freedom;


import com.freedom.mapper.OrderMapper;
import com.freedom.mapper.UserMapper;
import com.freedom.po.*;
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
public class OrderTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws Exception{
        String resource = "mybatis.xml";
        InputStream inputstream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputstream);

    }

    @Test
    public void testFindOrderUser()throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        List<OrderCustom> orderCustomList = orderMapper.findOrdersUser();
        System.out.println(orderCustomList);
        sqlSession.close();
    }

    @Test
    public void findOrdersUserResultMap()throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        List<Order> orderLIst = orderMapper.findOrdersUserResultMap();
        System.out.println(orderLIst);
        sqlSession.close();
    }

    @Test
    public void findOrderDetailResultMap()throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        List<Order> orderLIst = orderMapper.findOrderDetailResultMap();
        System.out.println(orderLIst);
        sqlSession.close();
    }

    @Test
    public void findUserItemsResultMap()throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        List<User> userLIst = orderMapper.findUserItemsResultMap();
        System.out.println(userLIst);
        sqlSession.close();
    }

    @Test
    public void findOrderUserLazyLoad()throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        List<Order> OrderList = orderMapper.findOrderUserLazyLoad();

        for(Order order:OrderList){
            User user = order.getUser();
            System.out.println(user);
        }
       // System.out.println(OrderList);
        sqlSession.close();
    }

    @Test
    public void testCache1() throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user1 =userMapper.findUserById(1);
        System.out.println(user1);
        user1.setUserName("王大锤");
        userMapper.updateUser(user1);
        User user2 =userMapper.findUserById(1);
        System.out.println(user2);
        sqlSession.close();
    }

    @Test
    public void testCache2() throws Exception{
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        SqlSession sqlSession3 = sqlSessionFactory.openSession();

        UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);
        User user1 =userMapper1.findUserById(1);
        sqlSession1.close();

        UserMapper userMapper3 = sqlSession3.getMapper(UserMapper.class);
        User user3=userMapper3.findUserById(1);
        user3.setUserName("王五");
        userMapper3.updateUser(user3);
        sqlSession3.commit();
        sqlSession3.close();

        UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
        User user2 =userMapper2.findUserById(1);
        sqlSession2.close();

    }
}
