package com.baizhi.service;

import com.baizhi.entity.Department;

import java.util.List;

public interface DepartmentService {
    //部门表查询所有
    public List<Department> modifyselectShowAll();
    public List<Department> modifyShowALl();
    //添加部门
    public void modifyInsertShowAll(Department department);
    //查询id
    public Department selectShowAll(Integer id);
    //更新修改
    public void modifyUpdateShowAll(Department department);

}
