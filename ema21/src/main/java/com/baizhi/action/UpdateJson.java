package com.baizhi.action;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/Yun")
@Controller
public class UpdateJson {
    @Autowired
    private UserService userService;

    @RequestMapping("/selectByName")
    public @ResponseBody
    User UpdateByJosy(String username){
        return userService.findByName(username);
    }

}
