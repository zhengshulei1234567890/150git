package com.baizhi.action;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@RequestMapping("/Yun")
@Controller
public class QueryAllAction {

    @Autowired
    private UserService userService;

    @RequestMapping("/queryAll")
    public String queryAll(Model model){
        List<User> list = userService.queryAll();
        model.addAttribute("list",list);
        return "admin";
    }

    @RequestMapping("/queryOneByName")
    public String queryOneByName(HttpSession session, Model model){
        User user = (User)session.getAttribute("admin");
        session.setAttribute("admin",user.getUsername());
        model.addAttribute("User",user);
        return "userlist";
    }
}
