package com.baizhi.service;

import com.baizhi.entity.Users;

import java.util.List;

public interface UsersService {
    //注册
    public void register(Users users);
    public List<Users> showAll();
    //登录
    public  Users login(String name,String password);
}
