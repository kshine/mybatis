package com.freedom;


import com.freedom.mapper.OrderMapper;
import com.freedom.mapper.UserMapper;
import com.freedom.po.OrderCustom;
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






}
