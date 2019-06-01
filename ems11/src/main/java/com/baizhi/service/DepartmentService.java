package com.baizhi.service;

import com.baizhi.entity.Department;

import java.util.List;

public interface DepartmentService {
    //查询所有
    public List<Department> queryAll();
    //添加
    public void save(Department department);
    //回显
    public Department selectByID(Integer id);
    //修改
    public void update(Department department);
    //查所有员工
    public Department queryAllEmployee(Integer id);

    //查所有部门
    public List<Department> selectAll();

}
