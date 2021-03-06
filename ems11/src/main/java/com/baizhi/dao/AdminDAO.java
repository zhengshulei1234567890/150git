package com.baizhi.dao;

import com.baizhi.entity.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminDAO {
    //登录
    public Admin selectByUserName(@Param("username") String username, @Param("password") String password);
    //注册
    public void save(Admin admin);
}
