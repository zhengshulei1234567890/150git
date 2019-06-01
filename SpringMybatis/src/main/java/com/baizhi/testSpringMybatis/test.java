package com.baizhi.testSpringMybatis;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import com.baizhi.Service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class test {
    @Test
    public void test1(){
        //构建Spring工厂
        ApplicationContext cpxalc = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取Dao实现类 创建好的实现类对象 默认id是 接口名称shouzimu小写
        UserDao userDao= (UserDao) cpxalc.getBean("userDao");
       // System.out.println(userDao.getClass());
      userDao.register(new User(null,"威锋网","123454",4322.2));
        //userDao.update(new User(2,"大学东方","123456",34223.32));
        //List<User> users = userDao.selectAll();
        //for (User user : users) {
           // System.out.println(user);
        //}
       // userDao.delete(1);
        Integer[] ids={3,4};
        userDao.deleteById(ids);

    }
     @Test
    public void test2(){
         //构建Spring工厂
     ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
         UserService userService = (UserService) ac.getBean("userService");
        // userService.modifyregister(new User(null,"电风扇","123456",324.32));
            //userService.modifyupdate(new User(1,"所得税","123421",324324.32));
         //List<User> users = userService.modifyselectAll();
        // for (User user : users) {
           //  System.out.println(user);
       //  }
       // userService.modifydelete(5);
        Integer[] ids={2};
        userService.modifydeleteById(ids);
     }




}
