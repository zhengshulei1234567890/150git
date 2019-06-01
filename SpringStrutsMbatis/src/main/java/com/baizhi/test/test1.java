package com.baizhi.test;

import com.baizhi.dao.AdminDao;
import com.baizhi.dao.DepartmentDao;
import com.baizhi.dao.EmployeesDao;
import com.baizhi.entity.Admin;
import com.baizhi.entity.Department;
import com.baizhi.entity.Employees;
import com.baizhi.service.DepartmentService;
import com.baizhi.service.EmployeesService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.annotation.Target;
import java.util.List;

public class test1 {
    @Test
    public void test1() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        AdminDao adminDao = (AdminDao) ac.getBean("adminDao");
        adminDao.loginAll("lisi", "123456");
    }

    @Test
    public void test2() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        AdminDao adminDao = (AdminDao) ac.getBean("adminDao");
        adminDao.registerAll(new Admin(null, "张三", "张三", "123456", "男"));
    }

    @Test
    public void test3() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeesService employeesService = (EmployeesService) ac.getBean("employeesService");
        List<Employees> employees = employeesService.modifyRefisterShowALl();
        for (Employees employee : employees) {
            System.out.println(employee);
        }
    }

    @Test
    public void test4() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
       /* DepartmentDao departmentDao= (DepartmentDao) ac.getBean("departmentDao");
        List<Department> departments = departmentDao.selectAll();
        for (Department department : departments) {
            System.out.println(department);
        }
    }*/
        DepartmentService departmentService = (DepartmentService) ac.getBean("departmentService");
        List<Department> departments = departmentService.modifyselectShowAll();
        for (Department department : departments) {
            System.out.println(department);
        }
    }
    @Test
    public void test5() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeesDao employeesDao = (EmployeesDao) ac.getBean("employeesDao");
        employeesDao.deleteAll(1);

    }
    @Test
    public void test6(){
        ApplicationContext as = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeesDao employeesDao = (EmployeesDao) as.getBean("employeesDao");
        Employees employees = employeesDao.selectById(4);
        System.out.println(employees);
    }
    @Test
    public   void   test7(){
        ApplicationContext  ac=new  ClassPathXmlApplicationContext("applicationContext.xml");
        DepartmentDao departmentDao =(DepartmentDao) ac.getBean("departmentDao");
        List<Department> list = departmentDao.showAll();
        for (Department department : list) {
            System.out.println(department);
        }
    }
}
