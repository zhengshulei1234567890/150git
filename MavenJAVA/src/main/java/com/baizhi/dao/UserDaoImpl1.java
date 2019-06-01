package com.baizhi.dao;

public class UserDaoImpl1 implements UserDao{
    @Override
    public void save() {
        System.out.println("我是UserDAOImpl1中的插入方法");
    }
}
