package com.baizhi.action;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminAction {
    @Autowired
    private AdminService adminService;
    //查询所有
    @RequestMapping("/queryAdmin")
    public String queryShowAll(Model model){
        List<Admin> list = adminService.queryShowAll();
        model.addAttribute("list",list);
        return "admin";
    }


    //注册
    /*@RequestMapping("register")
    public String register(Admin admin){
        adminService.save(admin);
        return "login";
    }

    //查询id
    public String selectId(Integer id){
        Admin admin = adminService.selectId(id);
        return "";
    }
    //修改
    public String updateShowAll(Admin admin){
        adminService.update(admin);
        return "";
    }*/


}
