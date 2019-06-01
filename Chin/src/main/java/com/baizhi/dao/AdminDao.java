package com.baizhi.dao;

import java.util.List;

import com.baizhi.entity.Admin;
import org.apache.ibatis.annotations.Param;


public interface AdminDao {
	public List<Admin> findAll();
	//登陆
	public Admin findLogin(@Param("username") String username, @Param("password") String password);

}
