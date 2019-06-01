package com.baizhi.service;

import com.baizhi.entity.User;

import java.util.List;

public interface UserService {
    //查询所有
    public List<User> queryAll();
    //添加
    public void save(User user);

}
