package com.baizhi.action;

import com.baizhi.entity.Admin;
import com.baizhi.entity.User;
import com.baizhi.service.AdminService;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserAction {

    @Autowired
    private UserService userService;
    @Autowired
    private AdminService adminService;

    @RequestMapping("/showAll")
    public String showAll(String username, String password, String role, HttpSession session) throws Exception {
        if ("uesr".equals(role)) {
            System.out.println("uesr".equals(role));
            User user = userService.showAll(username, password);
            System.out.println(user);
            if (user != null) {
                session.setAttribute("user",user);
                return "user/queryAll.do";
            }else {
                return "login";
            }
        } else if ("admin".equals(role)) {
            Admin admin = adminService.loginShowAll(username, password);
            if (admin!=null){
                return "forward:/admin/queryAdmin.do";
            }else {
                return "login";
            }
        }
        return null;
    }

    //展示所有
    @RequestMapping("/queryAll")
    public String queryAll(Model model)throws Exception{
        List<User> list = userService.queryAll();
        model.addAttribute("list",list);
        return "userlist";
    }
}
