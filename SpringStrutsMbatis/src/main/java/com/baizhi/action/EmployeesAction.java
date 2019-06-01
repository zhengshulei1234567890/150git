package com.baizhi.action;

import com.baizhi.entity.Employees;
import com.baizhi.service.EmployeesService;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;


import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
@Controller
@Scope("prototype")
public class EmployeesAction extends ActionSupport {
    @Autowired
    private EmployeesService employeesService;
    private Integer id;
    private Employees employees;

    public Employees getEmployees() {
        return employees;
    }

    public void setEmployees(Employees employees) {
        this.employees = employees;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /*public EmployeesService getEmployeesService() {
        return employeesService;
    }

    public void setEmployeesService(EmployeesService employeesService) {
        this.employeesService = employeesService;
    }
*/
    // 文件本身
    private File cover;
    // 文件类型
    private String coverContentType;
    // 文件名字
    private String coverFileName;

    public File getCover() {
        return cover;
    }

    public void setCover(File cover) {
        this.cover = cover;
    }

    public String getCoverContentType() {
        return coverContentType;
    }

    public void setCoverContentType(String coverContentType) {
        this.coverContentType = coverContentType;
    }

    public String getCoverFileName() {
        return coverFileName;
    }

    public void setCoverFileName(String coverFileName) {
        this.coverFileName = coverFileName;
    }

    //查询所有
    public String selectAllEmp(){
        List<Employees> employees = employeesService.modifyRefisterShowALl();
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("employees",employees);
        return  "selectAllEmp";
    }
    //删除
    public String deleteAllEmp(){
        employeesService.modifyDeleteShowAll(id);
        return "deleteAllEmp";

    }
    //查询id
    public String selectById(){
        Employees employees = employeesService.modifySelectById(id);
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("employees",employees);
        return "selectById";
    }
    //修改
    public String updateShowAll(){
        employeesService.modifyUpdateShowAll(employees);
        return "updateShowAll";
    }
    //添加
    public String insertShowAll(){
        employeesService.modifyInsertShowAll(employees);
        return "insertShowAll";
    }

}
