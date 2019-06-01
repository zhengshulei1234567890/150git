package com.baizhi.test;

import com.baizhi.dao.AdminaDao;
import com.baizhi.dao.UsersDao;
import com.baizhi.entity.Admina;
import com.baizhi.entity.Users;
import com.baizhi.service.AdminaService;
import com.baizhi.service.UsersService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.w3c.dom.UserDataHandler;

import java.util.List;

public class testUsers {
    @Test
    public void test1(){
        ApplicationContext as = new ClassPathXmlApplicationContext("applicationContext.xml");
         AdminaDao adminaDao =(AdminaDao) as.getBean("adminaDao");
        adminaDao.loginUsers("lisi","123456");
        //AdminaService a =(AdminaService) as.getBean("adminaService");
        //a.loginNamePass("lisi","123456");
       /* UsersDao usersDao = (UsersDao) as.getBean("usersDao");
        List<Users> users = usersDao.selectAll();
        for (Users user : users) {
            System.out.println(user);
        }*/
       /* UsersService usersService = (UsersService) as.getBean("usersService");
        List<Users> users1 = usersService.selectShowAll();
        for (Users users2 : users1) {
            System.out.println(users2);
        }*/
    }
   /*@Test
    public void test2(){
        ApplicationContext as = new ClassPathXmlApplicationContext("applicationContext.xml");
        UsersDao usersDao =(UsersDao) as.getBean("usersDao");
        usersDao.registerAll(new Users(null,"lisi","12345","男","lisi"));
    }
    @Test
    public void test3(){
        ApplicationContext as = new ClassPathXmlApplicationContext("applicationContext.xml");
        UsersService userService = (UsersService) as.getBean("usersService");
        userService.modifyRegistAll(new Users(null,"ww","123456","女","ww"));

    }*/
   @Test
   public void test4(){
       ApplicationContext as = new ClassPathXmlApplicationContext("applicationContext.xml");
        AdminaService adminaService = (AdminaService) as.getBean("adminaService");
        adminaService.modifyRegistAll(new Admina(null,"w","123456","男","w"));

   }
   @Test
    public void test5(){
       ApplicationContext as = new ClassPathXmlApplicationContext("applicationContext.xml");
      // UsersDao usersDao =(UsersDao) as.getBean("usersDao");
        //usersDao.deleteAll(4);
       UsersService usersService = (UsersService) as.getBean("usersService");
        usersService.modifydeleteShowAll(3);
   }
    @Test
    public void test6(){
        ApplicationContext as = new ClassPathXmlApplicationContext("applicationContext.xml");
        UsersService usersService = (UsersService)as.getBean("usersService");
        usersService.modifyupdateShowAll(new Users(2,"rrr","12","212","null"));

   }



}
