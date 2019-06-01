package com.baizhi.action;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/Yun")
public class OperationAction {

    @Autowired
    private UserService userService;

    @RequestMapping("/delete")
    public String delete(String username){
        userService.deleteByName(username);
        return "redirect:/Yun/queryAll.do";
    }


    @RequestMapping("/AddUser")
    public String insert(User user){
        userService.addUser(user);
        return "redirect:/Yun/queryAll.do";
    }

    @RequestMapping("FindOneServlet")
    public String LikeFind(Model model, String username){
        List<User> users =  userService.findByNameLike(username);
        model.addAttribute("list",users);
        return "admin";
    }


    @RequestMapping("/updateStatus")
    public String updateStatus(User user){
        User user1 = userService.findByName(user.getUsername());
        if("正常".equals(user1.getStatus())){
            user1.setStatus("冻结");
        }else{
            user1.setStatus("正常");
        }
        userService.updateStatus(user1);
        return "redirect:/Yun/queryAll.do";
    }

    @RequestMapping("updateUser")
    public String updateUser(User user){
        User user1 = userService.findByName(user.getUsername());
        userService.updateStatus(user);
        return "forward:/Yun/queryAll.do";
    }
}
