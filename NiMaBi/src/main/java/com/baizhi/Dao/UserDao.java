package com.baizhi.Dao;

import com.baizhi.entity.User;

public interface UserDao {
    //插入一条数据
    public void save(User user);
    public User selectAll(String username);
}
