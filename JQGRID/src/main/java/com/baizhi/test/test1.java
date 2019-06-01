package com.baizhi.test;

import com.baizhi.dao.DepartmentDao;
import com.baizhi.dao.UserDao;
import com.baizhi.entity.Department;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class test1 {

    @Test
    public void test2(){
       ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao =(UserDao) ac.getBean("userDao");
        List<User> users = userDao.showAll(1, 3);
        for (User user : users) {
            System.out.println(user);
        }


    }
    @Test
    public void test3(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService =(UserService) ac.getBean("userService");
    }
    @Test
    public void test4(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        DepartmentDao departmentDao = (DepartmentDao)ac.getBean("departmentDao");
        List<Department> departments = departmentDao.showAll();
        for (Department department : departments) {
            System.out.println(department);
        }
    }


}
