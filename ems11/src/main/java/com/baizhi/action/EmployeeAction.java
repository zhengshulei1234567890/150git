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
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/employee")
public class EmployeeAction{
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;

    //员工表添加
    //指定访问路径
    @RequestMapping("/addEmp")//通过对象接受对应的参数
    public String addEmp(Employee employee, MultipartFile upload,HttpSession session)throws Exception{
        //获取目标文件夹upload的绝对路径
        ServletContext servletContext = session.getServletContext();
        String realPath = servletContext.getRealPath("/upload");
        //创建一个和上传文件命名相同的文件 该文件没有内容
        File file = new File(realPath + "/" + upload.getOriginalFilename());
        //把上传的文件内容  传输到空的文件中
        upload.transferTo(file);
        employee.setHead(upload.getOriginalFilename());

        employeeService.addEmp(employee);
        return "redirect:/department/queryAll.do";
    }

    //回显ID
    @RequestMapping("selectByID")
    public String selectByID(Integer id, HttpServletRequest request) throws  Exception{
        Employee employee = employeeService.selectByID(id);
        request.setAttribute("employee" ,employee);
        return "updateEmp";
    }
    //修改
    @RequestMapping("updateEmp")
    public String updateEmp(Employee employee, MultipartFile upload,Model model,HttpSession session)throws Exception {
        if(upload.getOriginalFilename()!=null && !("").equals(upload.getOriginalFilename())){
            //获取目标文件夹upload的绝对路径
            ServletContext servletContext = session.getServletContext();
            String realPath = servletContext.getRealPath("/upload");
            //创建一个和上传文件命名相同的文件 该文件没有内容
            File file = new File(realPath + "/" + upload.getOriginalFilename());
            //把上传的文件内容  传输到空的文件中
            upload.transferTo(file);
            employee.setHead(upload.getOriginalFilename());
        }
        employeeService.updateEmp(employee);
        Department department = departmentService.queryAllEmployee(employee.getDept_id());

        model.addAttribute("id",employee.getDept_id());

        return "redirect:/department/queryAllEmployee.do";
    }
    // 删除
    @RequestMapping("/delete")
    public String delete(Integer id,Integer depId,Model model)throws  Exception{
        employeeService.delete(id);
        model.addAttribute("id",depId);
        return "redirect:/department/queryAllEmployee.do";

    }

}
