package com.baizhi.controller;

import com.baizhi.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/first")
public class FirstSpringMVC {

    @RequestMapping("/t")
    public String test(Model model)throws Exception{
        model.addAttribute("name","小何");
        System.out.println("我是第一个springMVC开发程序");
        return "scope";
    }
    /*
    * ModelAndView机制
    * 作用：传递数据（相当于Resquest作用域）并跳转页面
    * */
    //利用ModelLandView进行传值并跳转页面
    @RequestMapping("/mav")
    public ModelAndView testmav()throws Exception{//ModelAndView:返回值是ModelAndView
        //创建ModelAndView对象
        ModelAndView modelAndView = new ModelAndView();
        //相当于向Request作用域中存值
        modelAndView.addObject("name","小白");//"小白"：向Resquest作用域中存值
        //设置相应的跳转路径
        modelAndView.setViewName("scope");//scope:跳转路径
        return modelAndView;
    }
    /*
    * @ResponseBody注解
    * */
    //测试jackson  把java对象转换为JSON串
    @RequestMapping("/jackson")
    public @ResponseBody User testjackson()throws Exception{
        User user = new User(1, "李四", "12345");
        return user;
    }


    //测试jackson把java集合<List>转换为JSON串
    @RequestMapping("/jackson1")
    //使用Jackson时，如果是对象和集合自动转换json串时，需要把对象或集合类型作为方法的返回值，并
    //并在该返回值的前边加@ResponseBody注解
    public @ResponseBody List<User> testjackson1()throws  Exception{
        ArrayList<User> users = new ArrayList<>();
        User user = new User(1, "李四", "12345");
        User user2 = new User(2, "李四2", "12345");
        User user3 = new User(3, "李四3", "12345");
        users.add(user);
        users.add(user2);
        users.add(user3);
        return users;
    }
}
