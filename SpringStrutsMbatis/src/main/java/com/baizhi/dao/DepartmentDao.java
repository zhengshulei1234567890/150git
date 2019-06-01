package com.baizhi.dao;

import com.baizhi.entity.Department;

import java.util.List;

public interface DepartmentDao {
    //部门表查询所有
    public List<Department> selectAll();

    public List<Department> showAll();
    //添加部门
    public void insertAll(Department department);
    //更新部门（修改）
    public void updateAll(Department department);
    //查询id
    public Department selectById(Integer id);
}
