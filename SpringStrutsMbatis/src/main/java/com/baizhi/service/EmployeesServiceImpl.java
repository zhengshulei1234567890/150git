package com.baizhi.service;

import com.baizhi.dao.EmployeesDao;
import com.baizhi.entity.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeesServiceImpl implements EmployeesService {
    @Autowired
    private EmployeesDao employeesDao;

    public EmployeesDao getEmployeesDao() {
        return employeesDao;
    }

    public void setEmployeesDao(EmployeesDao employeesDao) {
        this.employeesDao = employeesDao;
    }
    //查询所有
    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Employees> modifyRefisterShowALl() {
        List<Employees> employees = employeesDao.selectAll();
        return employees;
    }
    //删除
    @Override
    public void modifyDeleteShowAll(Integer id) {
        employeesDao.deleteAll(id);
    }
    //查询id
    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Employees modifySelectById(Integer id) {
        Employees employees = employeesDao.selectById(id);
        return employees;
    }
    //修改
    @Override
    public void modifyUpdateShowAll(Employees employees) {

        employeesDao.updateAll(employees);
    }
    //添加
    @Override
    public void modifyInsertShowAll(Employees employees) {
        employeesDao.insertAll(employees);
    }
}
