package com.baizhi.test;

import com.baizhi.dao.UsersDao;
import com.baizhi.entity.Users;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class trst1 {


    @Test
    public void test2(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationcontext.xml");
        UsersDao usersDao = (UsersDao) ac.getBean("usersDao");
        usersDao.save(new Users(null,"ss","33","32333"));
    }
}
