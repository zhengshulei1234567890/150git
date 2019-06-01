package com.baizhi.action;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RequestMapping("/Yun")
@Controller
public class RegisterAction {

    @Autowired
    private UserService userService;

    @RequestMapping("/register")
    public String register(User user, HttpSession session, HttpServletRequest request){
        user.setStatus("正常");
        user.setIp("192.168.0.1");
        user.setSource("微信");
        userService.register(user);
        session.setAttribute("admin",user.getUsername());
        request.setAttribute("User",user);
        return "userlist";
    }

}
