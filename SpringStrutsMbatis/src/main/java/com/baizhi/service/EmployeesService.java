package com.baizhi.service;

import com.baizhi.entity.Employees;

import java.util.List;

public interface EmployeesService {
    //查询所有
    public List<Employees> modifyRefisterShowALl();
    //删除
    public void modifyDeleteShowAll(Integer id);
    //查询id
    public Employees modifySelectById(Integer id);
    //修改
    public void modifyUpdateShowAll(Employees employees);
    //添加
    public void modifyInsertShowAll(Employees employees);
}
