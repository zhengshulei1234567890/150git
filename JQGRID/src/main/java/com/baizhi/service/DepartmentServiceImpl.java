package com.baizhi.service;

import com.baizhi.dao.DepartmentDao;
import com.baizhi.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Service
@Transactional
public class DepartmentServiceImpl implements  DepartmentService{
    @Autowired
    private DepartmentDao departmentDao;
    @Override
    public List<Department> showAll() {
        List<Department> departments = departmentDao.showAll();
        return departments;
    }
}
