package com.baizhi.dao;

import com.baizhi.entity.Department;

import java.util.List;

public interface DepartmentDao {
    //查询部门
    public List<Department> showAll();
}
