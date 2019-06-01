package com.baizhi.action;

import com.baizhi.entity.Admin;
import com.baizhi.entity.User;
import com.baizhi.service.AdminService;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/Yun")
public class LoginAction {

    @Autowired
    private UserService userService;
    @Autowired
    private AdminService adminService;

    @RequestMapping("/login")
    public  String login(String name, String pwd, String role, HttpServletRequest request, HttpSession session) {
        if ("admin".equals(role)) {
            Admin admin = adminService.login(name, pwd);
            if (admin != null) {
                session.setAttribute("admin", admin);
                return "redirect:/Yun/queryAll.do";
            } else {
                try {
                    throw new RuntimeException("账号或密码输入错误");
                } catch (Exception e) {
                    String message = e.getMessage();
                    request.setAttribute("message", message);
                    return "forward:/login.jsp";
                }
            }
        } else if("user".equals(role)){
            User user = userService.queryUserByNameAndpassword(name, pwd);
            if(user.getStatus().equals("正常")){
                if (user != null) {
                    session.setAttribute("admin", user);
                    return "forward:/Yun/queryOneByName.do";
                }else {
                    try {
                        throw new RuntimeException("账号或密码输入错误");
                    } catch (Exception e) {
                        String message = e.getMessage();
                        request.setAttribute("message", message);
                        return "forward:/login.jsp";
                    }
                }
            }else{
                try {
                    throw new RuntimeException("此账户已被冻结");
                } catch (Exception e) {
                    String message = e.getMessage();
                    request.setAttribute("message", message);
                    return "forward:/login.jsp";
                }
            }
        }
        return null;
    }

    //退出登陆
    @RequestMapping("/ExitServlet")
    public String logOut(HttpSession session){
        session.invalidate();
        return "login";
    }
}
