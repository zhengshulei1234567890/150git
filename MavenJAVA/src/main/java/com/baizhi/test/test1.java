package com.baizhi.test;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.Count;
import com.baizhi.entity.Student;
import com.baizhi.entity.User;
import com.baizhi.Service.UserService;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;

public class test1 {
    @Test
    public void test2(){
        //构建spring工厂
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
        //构建对象
        User user = (User)ac.getBean("user");
        System.out.println(user);
    }
    @Test
    public   void  testSpring1(){
        //构建Spring工厂
        ApplicationContext ac= new  ClassPathXmlApplicationContext("applicationContext.xml");
        Count count =(Count) ac.getBean("count");
        System.out.println(count);
    }

    @Test
    public  void   testSpring3(){
        ApplicationContext ac=new  ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao  ud=(UserDao) ac.getBean("userDao");
        ud.save();
    }
    @Test
    public  void   testSpring4(){
        ApplicationContext ac=new  ClassPathXmlApplicationContext("applicationContext.xml");
        UserService  ud=(UserService) ac.getBean("userService");
        ud.register();
    }
    //创建connection对象
     @Test
    public void test6(){
        //构建spring工厂对象
         ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
         //注意  FactoryBean技术 通过id获取到的是由该类创建的复杂对象
         Connection conn=(Connection)ac.getBean("conn");
         Connection conn1=(Connection)ac.getBean("conn");
         System.out.println(conn);
         System.out.println(conn1);
     }
     //创建sqlsessionFactory对象
    @Test
    public void testSqlSessionFactory(){
        //构建spring的工厂
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        SqlSessionFactory sqf = (SqlSessionFactory) ac.getBean("sqlSessionFactory");
        System.out.println(sqf);
    }
    //创建student对象
    //构建Spring的工厂
     @Test
     public void testStudent() {
         ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
         Student stu = (Student) ac.getBean("stu");
         Student stu1 = (Student) ac.getBean("stu");
         System.out.println(stu);
         System.out.println(stu1);
     }

}
