package com.baizhi.action;

import com.baizhi.entity.Department;
import com.baizhi.entity.Employee;
import com.baizhi.service.DepartmentService;
import com.baizhi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
@RequestMapping("/department")
public class DepartmentAction  {
    @Autowired
    private DepartmentService departmentService;
    private Department department;
    private Integer id;

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

    //部门展示所有
    @RequestMapping("/queryAll")//通过对象接受对应的参数
    public String queryAll(Model model){
        List<Department> departments = departmentService.queryAll();
        model.addAttribute("departments",departments);
        return "departments";
    }
    //添加部门
    @RequestMapping("save")
    public String save(Department department,HttpSession session)throws Exception{
        departmentService.save(department);
        return "redirect:/department/queryAll.do";
    }
    //回显id
    @RequestMapping("selectByID")
    public String selectByID(Integer id,HttpServletRequest request)throws  Exception{
        Department department = departmentService.selectByID(id);
        request.setAttribute("department",department);
        return "updateDepartment";
    }
    //更新
    @RequestMapping("/update")
    public String update(Department department,HttpSession session)throws Exception{
        departmentService.update(department);
        return "redirect:/department/queryAll.do";
    }
    //员工列表查询Id
    @RequestMapping("/queryAllEmployee")
    public String queryAllEmployee(Department dep,Model model)throws Exception{
        Department department = departmentService.queryAllEmployee(dep.getId());
        model.addAttribute("department",department);
        return "emplist";
    }
    //ajax
    @RequestMapping("/selectAll")
    public @ResponseBody List<Department> selectAll()throws Exception {
        List<Department> departments = departmentService.selectAll();
        System.out.println(departments);
        return departments;
    }
}
