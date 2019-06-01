package com.baizhi.entity;

public class Department {
    private Integer id;
    private String deptnumber;
    private String deptname;

    public Department() {
    }

    public Department(Integer id, String deptnumber, String deptname) {
        this.id = id;
        this.deptnumber = deptnumber;
        this.deptname = deptname;
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

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", deptnumber='" + deptnumber + '\'' +
                ", deptname='" + deptname + '\'' +
                '}';
    }
}
