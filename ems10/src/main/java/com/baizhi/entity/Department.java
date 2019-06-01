package com.baizhi.entity;

import java.util.List;

public class Department {
    private Integer id;
    private String deptnumber;
    private String deptname;
    private List<Employee> list;

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", deptnumber='" + deptnumber + '\'' +
                ", deptname='" + deptname + '\'' +
                ", list=" + list +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeptnumber() {
        return deptnumber;
    }

    public void setDeptnumber(String deptnumber) {
        this.deptnumber = deptnumber;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public List<Employee> getList() {
        return list;
    }

    public void setList(List<Employee> list) {
        this.list = list;
    }

    public Department() {
    }

    public Department(Integer id, String deptnumber, String deptname, List<Employee> list) {
        this.id = id;
        this.deptnumber = deptnumber;
        this.deptname = deptname;
        this.list = list;
    }
}
