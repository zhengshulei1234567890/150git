package com.baizhi.dao;

import com.baizhi.entity.Admina;
import com.baizhi.entity.Admina;
import org.apache.ibatis.annotations.Param;

public interface AdminaDao {
    //登录
    public Admina loginUsers(@Param("username")String username, @Param("password")String password);
    //注册
    public void registerAll(Admina admina);
}
