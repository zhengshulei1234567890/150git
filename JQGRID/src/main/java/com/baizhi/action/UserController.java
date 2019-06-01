package com.baizhi.action;


import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/showAll")
    public @ResponseBody Map<String,Object> showAll(Integer page, Integer rows){
       // System.out.println(page+"\t"+rows);
        Map<String, Object> map = userService.show(page, rows);
        //System.out.println(map);
        return map;
    }
}
