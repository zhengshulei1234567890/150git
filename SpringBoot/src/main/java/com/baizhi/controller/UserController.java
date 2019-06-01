package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/queryAll")
    public String queryAll(HttpSession session){
        List<User> user = userService.queryAll();
        System.out.println("sssssssssssss");
        session.setAttribute("user",user);
        return "index";
    }
    @RequestMapping("/save")
    public void save(){
        //User user = new User(null, "小小", "123321");
        //userService.save(user);

    }
    @RequestMapping("/index")
    public String  index(){
        return "index";
    }
}
