package com.baizhi.entity;

public class Count {
    private Integer id;
    private String accountName;
    private double salary;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Count() {
    }

    public Count(Integer id, String accountName, double salary) {
        this.id = id;
        this.accountName = accountName;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    @Override
    public String toString() {
        return "Count{" +
                "id=" + id +
                ", accountName='" + accountName + '\'' +
                ", salary=" + salary +
                '}';
    }
}
