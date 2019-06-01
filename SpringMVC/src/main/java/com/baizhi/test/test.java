package com.baizhi.test;

import com.baizhi.dao.UsersDao;
import com.baizhi.entity.Users;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    @Test
    public void test1(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        UsersDao usersDao = (UsersDao) ac.getBean("usersDao");
        usersDao.save(new Users(null,"小","17","66666","123456"));
    }
}
