package com.baizhi.action;

import com.alibaba.fastjson.JSON;
import com.baizhi.Service.UserService;
import com.baizhi.Service.UserServiceImpl;
import com.baizhi.entity.User;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class UserAction extends ActionSupport {
    //    接受的注册数据
    private User user;
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String register() {
//        调用service
        UserService userService = new UserServiceImpl();
        userService.register(user);
        return "registreOk";
    }


    public String showAll() {
        UserService us = new UserServiceImpl();
        User user = us.showAll("username");
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("UTF-8");

        try {
            PrintWriter out = response.getWriter();
            if (user != null) {
                String s = "error.jpg";
                String jsonString = JSON.toJSONString(s);
                out.print(jsonString);
            } else {
                String s = "ok.gif";
                String jsonString = JSON.toJSONString(s);
                out.print(jsonString);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
