package com.baizhi.Service;

import com.baizhi.entity.Admin;

import java.util.List;



public interface AdminService {
	public List<Admin> findAll();
	//登录
	public Admin findLogin(String username, String password);

}
