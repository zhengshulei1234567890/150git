package com.baizhi.controller;

import com.baizhi.entity.Users;
import com.baizhi.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {
    //注入Service的实现类
    @Autowired
    private UsersService usersService;
    //指定访问路径
    @RequestMapping("register")//通过对象接受对应的参数
    public  String register(Users users, HttpSession session)throws Exception{
    //调用业务
        usersService.register(users);
        //注册添加标志位
        session.setAttribute("flag","Y");
        //跳转注册成功页面
        return "redirect:/users/showAll.do";
    }

    //指定查询路径
    @RequestMapping("/showAll")
    public String showAll(Model model)throws Exception{
        List<Users> users = usersService.showAll();
        //存在Request作用域
        model.addAttribute("users",users);
        return "showAll";
    }
    //登录
    @RequestMapping("/login")
    public String login(String name,String password,HttpSession session){
        Users users = usersService.login(name, password);
        if(users!=null){
            session.setAttribute("flag","Y");
            return "redirect:/users/showAll.do";
        }else{
            return "login";
        }
    }
}
