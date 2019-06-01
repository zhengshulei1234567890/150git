package com.baizhi.dao;

import com.baizhi.entity.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminDao {
    //登录
    public Admin loginAll(@Param("username")String username, @Param("password")String password);
    //注册
    public void registerAll(Admin admin);
}
