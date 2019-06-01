package com.baizhi.dao;

import com.baizhi.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    //通过分页进行查询         //当前页数                             每页显示条数
    public List<User> showAll(@Param("page") Integer page, @Param("rows") Integer rows);
    public Integer selectAll();

}
