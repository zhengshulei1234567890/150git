package com.baizhi.test;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class test1 {


    @Test
    public void  show(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao =(UserDao) ac.getBean("userDao");
        User user = userDao.showAll("王五", "123456");
        System.out.println(user);
    }


    @Test
    public void  sho1() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) ac.getBean("userDao");
        List<User> users = userDao.queryAll();
        System.out.println(users);
    }
}
