package com.baizhi.action;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

//生成Action对象
@Controller
//控制对象创建次数
@RequestMapping("/admin")
public class AdminAction {
    @Autowired
    private AdminService adminService;


    //指定访问路径
    @RequestMapping("/login")//通过对象接受对应的参数
    public String login(String username, String password, HttpSession session)throws Exception {
        Admin admin = adminService.login(username, password);
        if (admin != null) {
            session.setAttribute("flag", "Y");
            return "redirect:/department/queryAll.do";
        } else {
            return "login";
        }
    }
    //指定访问路径
    @RequestMapping("/regist")//通过对象接受对应的参数
    public String regist(Admin admin, HttpSession session)throws Exception{
        adminService.regist(admin);
        //注册添加标志位
        session.setAttribute("flag","Y");
        return "login";
    }
}
