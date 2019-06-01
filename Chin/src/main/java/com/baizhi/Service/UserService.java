package com.baizhi.Service;

import java.util.List;

import com.baizhi.entity.User;


public interface UserService {
		//用户管理
		public List<User> queryAllUser();
		//查询
		public User useremail(String email);
		public void update(User user);
		

		//注册
		public User insertUser(User user);
		public void update1(User user, String code);
		
		//front
		//登录
		public User selectAll(String email, String password);
		
}
