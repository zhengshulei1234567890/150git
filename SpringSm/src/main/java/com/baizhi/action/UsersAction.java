package com.baizhi.action;


import com.baizhi.entity.Users;
import com.baizhi.service.UsersService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.aspectj.util.FileUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class UsersAction extends ActionSupport {
    private UsersService usersService;
    private  Integer id;
    private Users users;
    private File head;
    private String headFileName;
    private String headContentType;

    public File getHead() {
        return head;
    }

    public void setHead(File head) {
        this.head = head;
    }

    public String getHeadFileName() {
        return headFileName;
    }

    public void setHeadFileName(String headFileName) {
        this.headFileName = headFileName;
    }

    public String getHeadContentType() {
        return headContentType;
    }

    public void setHeadContentType(String headContentType) {
        this.headContentType = headContentType;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UsersService getUsersService() {
        return usersService;
    }

    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }

    //查询所有
    public String selectShowAll(){
        HttpServletResponse response = ServletActionContext.getResponse();
        HttpServletRequest request = ServletActionContext.getRequest();
        List<Users> users = usersService.selectShowAll();
        request.setAttribute("users",users);
        return "selectAll";
    }
    //删除
    public String deleteShowAll(){
        usersService.modifydeleteShowAll(id);
        return "delete";
    }
    //查询ID
    public String selectById(){
        Users users = usersService.selectById(id);
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("users",users);
        return "select";
    }
    //修改
    public String updateShowAll(){
        /*if(head !=null) {
            String path = ServletActionContext.getServletContext().getRealPath("img");
            File file = new File(path, headFileName);
            try {
                FileUtil.copyFile(head, file);
            } catch (IOException e) {
                e.printStackTrace();
            }
            users.setHead(headFileName);
        }
        */
        usersService.modifyupdateShowAll(users);
        return "update";
    }
    //添加
    public String insertShowAll(){
        usersService.modifyinsertShowAll(users);
        return "insert";
    }
}
