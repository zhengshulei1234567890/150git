package com.baizhi.entity;

public class Department {
    private Integer id;
    private  String number;
    private  String department;

    public Department() {
    }

    public Department(Integer id, String number, String department) {
        this.id = id;
        this.number = number;
        this.department = department;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
