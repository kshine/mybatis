package com.freedom;

import com.freedom.mapper.RoleMapper;
import com.freedom.po.Role;
import com.freedom.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;

public class Chapter2Main {
    public static void main(String[] args) {
        SqlSession sqlSession = null;
        try{
            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
//            Role role = new Role();
//            role.setRoleName("testName");
//            role.setNote("testNote");
//            roleMapper.insertRole(role);
            roleMapper.deleteRole(3L);
            sqlSession.commit();
        }catch (Exception ex){
            System.err.println(ex.getMessage());
            sqlSession.rollback();
        }finally {
            if(sqlSession != null){
                sqlSession.close();
            }
        }
    }
}
