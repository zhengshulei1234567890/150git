package com.baizhi.entity;

public class Employee {
    private Integer id;
    private String head;
    private String name;
    private Double salary;
    private Integer age;
    private Integer dept_id;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", head='" + head + '\'' +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                ", dept_id=" + dept_id +
                '}';
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

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getDept_id() {
        return dept_id;
    }

    public void setDept_id(Integer dept_id) {
        this.dept_id = dept_id;
    }

    public Employee() {
    }

    public Employee(Integer id, String head, String name, Double salary, Integer age, Integer dept_id) {
        this.id = id;
        this.head = head;
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.dept_id = dept_id;
    }
}
