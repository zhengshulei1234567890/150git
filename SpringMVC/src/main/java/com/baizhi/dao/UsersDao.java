package com.baizhi.dao;

import com.baizhi.entity.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UsersDao {
    //插入
    public void  save(Users users);
    // 查询所有
    public List<Users> selectAll();
    //登录
    public Users loginusernameandpassword(@Param("name") String username, @Param("password") String password);
}
