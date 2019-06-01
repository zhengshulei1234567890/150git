package com.baizhi.controller;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;
    @RequestMapping("test")
    public Map<String, String> adminLogin(Admin admin, String enCode, HttpSession session) {
        System.out.println(admin+enCode);
        Map<String, String> map = adminService.adminLogin(admin.getUsername(), admin.getPassword(), enCode, session);
        return map;

    }
}
