package com.baizhi.entity;

public class Employees {
    private Integer id;
    private String head;//头像
    private String name;
    private String salary;
    private String age;
    private String department;
    private Integer d_id;

    public Employees() {
    }

    public Employees(Integer id, String head, String name, String salary, String age, String department, Integer d_id) {
        this.id = id;
        this.head = head;
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.department = department;
        this.d_id = d_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getD_id() {
        return d_id;
    }

    public void setD_id(Integer d_id) {
        this.d_id = d_id;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "id=" + id +
                ", head='" + head + '\'' +
                ", name='" + name + '\'' +
                ", salary='" + salary + '\'' +
                ", age='" + age + '\'' +
                ", department='" + department + '\'' +
                ", d_id=" + d_id +
                '}';
    }
}
