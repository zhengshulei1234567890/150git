package com.baizhi.entity;

public class Student {
    private Integer id;
    private String stuname;
    private double score;

    public Student() {
    }

    public Student(Integer id, String stuname, double score) {
        this.id = id;
        this.stuname = stuname;
        this.score = score;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }


   /* public String toString() {
        return "Student{" +
                "id=" + id +
                ", stuname='" + stuname + '\'' +
                ", score=" + score +
                '}';
    }*/
}
