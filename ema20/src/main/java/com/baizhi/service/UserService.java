package com.baizhi.service;

import com.baizhi.entity.User;

import java.util.List;

public interface UserService {
    //查询所有
    public List<User> queryAll();
    //登录
    public User showAll(String username,String password);
    //注册
    public void registerUser(User user);
}
