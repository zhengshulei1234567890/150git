package com.baizhi.dao;

import com.baizhi.entity.Employee;

public interface EmployeeDAO {
    //添加员工
    public void addEmp(Employee employee);
    //回显
    public Employee selectByID(Integer id);
    //修改
    public void updateEmp(Employee employee);
    //删除
    public void delete(Integer id);
}
