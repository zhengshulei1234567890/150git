package com.baizhi.dynimicproxy;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDynimicProxy {
    @Test
    public void test1(){
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        //代理类对象  通过原始类的ID 获取代理类的对象
        UserService userService =(UserService) ac.getBean("UserService");
        //System.out.println(userService.getClass());
      //userService.register();
        userService.register("小黑");
       // userService.register("小","1232");
      //userService.update();
       // AccountService as= (AccountService) ac.getBean("accountService");
        //as.register();

    }

}
