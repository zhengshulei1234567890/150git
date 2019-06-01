package com.baizhi.dao;

import java.util.List;

import com.baizhi.entity.User;
import org.apache.ibatis.annotations.Param;



public interface UserDao {

	//用户管理 查询
	public List<User> queryAllUser();
	//查询
	public User useremail(String email);	
	public void update(User user);
	
	//注册
	public void insertUser(User user);
	
	public void update1(User user);
	
		//front
	//登录
	public User selectAll(@Param("email") String email, @Param("password") String password);
	
}