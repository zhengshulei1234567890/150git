package com.baizhi.action;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/Yun")
@Controller
public class FindUserByPage {

    @Autowired
    private UserService userService;


    @RequestMapping("/FindAllUserByPage")
    public String page(Integer count, Model model) {
        List<User> list1 = userService.queryAll();
        List<User> list = userService.findUserByPage(count);
        //总条数
        Integer countNum = list1.size();
        //每次查询出的条数
        Integer count1 = list.size();
        //总页数
        Integer page = countNum / count1;

        model.addAttribute("page", page);
        model.addAttribute("list", list);

        return "forward:/admin.jsp";
    }
}
