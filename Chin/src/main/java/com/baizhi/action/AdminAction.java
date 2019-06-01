package com.baizhi.action;

import java.util.List;

import com.baizhi.Service.AdminService;
import com.baizhi.serviceImpl.AdminServiceImpl;
import com.baizhi.entity.Admin;
import org.apache.struts2.ServletActionContext;


public class AdminAction {




	public String query(){
		AdminService as= new AdminServiceImpl();
		List<Admin> list = as.findAll();
		ServletActionContext.getRequest().getSession().setAttribute("list",list);		
		return "ok";
		
	}
}
