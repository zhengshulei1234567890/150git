package com.baizhi.entity;

public class Users {
    private Integer id;
    private String name;
    private String age;
    private String salary;
    private String head;

    public Users() {
    }

    public Users(Integer id, String name, String age, String salary, String head) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.head = head;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", salary='" + salary + '\'' +
                ", head='" + head + '\'' +
                '}';
    }
}
