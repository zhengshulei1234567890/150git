package com.baizhi.action;

import com.baizhi.entity.Admina;
import com.baizhi.service.AdminaService;
import com.opensymphony.xwork2.ActionSupport;

public class AdminaAction extends ActionSupport {
    private AdminaService adminaService;
    private String username;
    private String password;
    private Admina admina;

    public AdminaService getAdminaService() {
        return adminaService;
    }

    public void setAdminaService(AdminaService adminaService) {
        this.adminaService = adminaService;
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

    public Admina getAdmina() {
        return admina;
    }

    public void setAdmina(Admina admina) {
        this.admina = admina;
    }

    //登录
    public String loginUsers(){
        adminaService.loginNamePass(username, password);
        // HttpServletRequest request = ServletActionContext.getRequest();
        //  request.setAttribute("users",users);
        return "login";
    }
    //注册
    public  String registShowAll(){
        adminaService.modifyRegistAll(admina);
        return "regist";
    }

}
