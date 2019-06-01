package com.baizhi.dao;

import com.baizhi.entity.User;

import java.util.List;

public interface UserDao {
    //注册
    public void register(User user);
    //修改
    public void update(User user);
    //查询所有
    public List<User> selectAll();
    //删除
    public void delete(Integer id);
    //批量删除
    public void deleteById(Integer[] ids);
}
