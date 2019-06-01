package com.baizhi.dao;

import com.baizhi.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    //用户登录
    public User showAll(@Param("username") String username, @Param("password") String password);
    //注册
    public void registerShowAll(User user);
    //展示所有
    public List<User> queryAll();
}
