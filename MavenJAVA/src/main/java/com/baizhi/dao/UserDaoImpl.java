package com.baizhi.dao;

public class UserDaoImpl implements UserDao{
    @Override
    public void save() {
        System.out.println("我是UserDAOImpl中的插入方法");
    }
}
