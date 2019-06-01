package com.baizhi.service;

import com.baizhi.dao.DepartmentDAO;
import com.baizhi.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentDAO departmentDAO;
    @Override
    @Transactional( propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Department> queryAll() {
        List<Department> departments = departmentDAO.queryAll();
        return departments;
    }

    @Override
    public void save(Department department) {
        departmentDAO.save(department);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Department selectByID(Integer id) {
        Department department = departmentDAO.selectByID(id);
        return department;
    }

    @Override
    public void update(Department department) {
        departmentDAO.update(department);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Department queryAllEmployee(Integer id) {
        Department department = departmentDAO.queryAllEmployee(id);
        return department;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Department> selectAll() {
        List<Department> departments = departmentDAO.selectAll();
        return departments;
    }
}
