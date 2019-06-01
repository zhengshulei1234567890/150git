package com.baizhi.action;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import com.opensymphony.xwork2.ActionSupport;

public class AdminAction extends ActionSupport {
   private AdminService adminService;
   private String username;
   private String password;
   private Admin admin;

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AdminService getAdminService() {
        return adminService;
    }

    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }

    //登录
    public String loginShowAll(){
        adminService.loginShowAll(username,password);
        return "login";
    }
    //注册
    public String registerShowAll(){
        adminService.modifyregisterShowAll(admin);
        return "register";
    }
}
