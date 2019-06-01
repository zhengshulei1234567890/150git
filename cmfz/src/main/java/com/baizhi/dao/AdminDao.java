package com.baizhi.dao;

import com.baizhi.entity.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminDao {
     //登录
     public Admin queryAll(String username);
     //添加
     public void insert(Admin admin);
}
