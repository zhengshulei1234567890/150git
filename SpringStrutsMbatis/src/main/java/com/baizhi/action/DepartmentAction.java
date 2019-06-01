package com.baizhi.action;

import com.alibaba.fastjson.JSON;
import com.baizhi.entity.Department;
import com.baizhi.entity.Employees;
import com.baizhi.service.DepartmentService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class DepartmentAction  extends ActionSupport {
    private DepartmentService departmentService;
    private Department department;
    private  Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public DepartmentService getDepartmentService() {
        return departmentService;
    }

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    //部门表查询所欲
    public String selectShowAll(){
        List<Department> departments = departmentService.modifyselectShowAll();
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("departments",departments);
        return "selectShowAll";
    }
    //
    public String ShowAll(){
        List<Department> departments = departmentService.modifyShowALl();
        String jsonString = JSON.toJSONString(departments);
        HttpServletResponse response = ServletActionContext.getResponse();
            response.setCharacterEncoding("UTF-8");
        try {
            PrintWriter out = response.getWriter();
            out.print(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    //添加部门
    public String insertShowAll(){
        departmentService.modifyInsertShowAll(department);
        return "insertShowAll";
    }
    //查询id
   public String selectById(){
       Department department = departmentService.selectShowAll(id);
       HttpServletRequest request = ServletActionContext.getRequest();
       request.setAttribute("department",department);
       return "selectById";
   }
   //更新修改
    public String updateShowAll(){
        departmentService.modifyUpdateShowAll(department);
        return "updateShowAll";
    }
}
