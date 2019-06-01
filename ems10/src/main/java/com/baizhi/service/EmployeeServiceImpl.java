package com.baizhi.service;

import com.baizhi.dao.EmployeeDAO;
import com.baizhi.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDAO employeeDAO;
    //添加
    @Override
    public void addEmp(Employee employee) {
        employeeDAO.addEmp(employee);
    }
    //查询回显
    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Employee selectByID(Integer id) {
        Employee employee = employeeDAO.selectByID(id);
        return employee;
    }
    //修改
    @Override
    public void updateEmp(Employee employee) {
        employeeDAO.updateEmp(employee);
    }
    //删除
    @Override
    public void delete(Integer id) {
        employeeDAO.delete(id);
    }
}
