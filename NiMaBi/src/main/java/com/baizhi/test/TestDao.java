package com.baizhi.test;

import com.baizhi.Dao.UserDao;
import com.baizhi.Service.UserService;
import com.baizhi.Service.UserServiceImpl;
import com.baizhi.entity.User;
import com.baizhi.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class TestDao {
    @Test
    public void testDao1(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        userDao.save(new User(null,"zhangsan","123456","20"));
        MybatisUtil.commit();
    }
    @Test
    public void test1(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User user = mapper.selectAll("zhangsan");
        System.out.println(user);
    }
    @Test
    public void test2(){
        UserService us=new UserServiceImpl();
        User user = us.showAll("zhangsan");
        System.out.println(user);
    }
}
