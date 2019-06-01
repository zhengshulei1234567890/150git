package com.baizhi.dao;


import com.baizhi.entity.Users;

import java.util.List;

public interface UsersDao {
    //查询所有
    public List<Users> selectAll();
    //删除
    public void deleteAll(Integer id);
    //查询Id
    public Users selectById(Integer id);
    //修改
    public void updateAll(Users users);
    //添加
    public void insertAll(Users users);
}
