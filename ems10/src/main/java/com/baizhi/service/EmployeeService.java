package com.baizhi.service;

import com.baizhi.entity.Employee;

public interface EmployeeService {
    //添加员工
    public void addEmp(Employee employee);
    //回显
    public Employee selectByID(Integer id);
    //修改
    public void updateEmp(Employee employee);
    //删除
    public void delete(Integer id);
}
