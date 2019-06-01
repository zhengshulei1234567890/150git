package com.baizhi.dao;

import com.baizhi.entity.Employees;

import java.util.List;

public interface EmployeesDao {
    //员工表查询所有
    public List<Employees> selectAll();
    //删除
    public void deleteAll(Integer id);
    //查询id
    public Employees selectById(Integer id);
    //修改
    public void updateAll(Employees employees);
    //添加
    public void insertAll(Employees employees);
}
