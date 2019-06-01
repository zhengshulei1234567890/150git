package com.baizhi.service;

import com.baizhi.dao.DepartmentDao;
import com.baizhi.entity.Department;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService{
    private DepartmentDao departmentDao;

    public DepartmentDao getDepartmentDao() {
        return departmentDao;
    }

    public void setDepartmentDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Override
    public List<Department> modifyselectShowAll() {
        List<Department> departments = departmentDao.selectAll();
        return departments;
    }

    @Override
    public List<Department> modifyShowALl() {
        List<Department> departments = departmentDao.showAll();
        return departments;
    }
    //添加部门
    @Override
    public void modifyInsertShowAll(Department department) {

        departmentDao.insertAll(department);
    }
    //查询id
    @Override
    public Department selectShowAll(Integer id) {
        Department department = departmentDao.selectById(id);
        return department;
    }
    //更新修改
    @Override
    public void modifyUpdateShowAll(Department department) {
        departmentDao.updateAll(department);
    }
}
