package com.baizhi.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.baizhi.Service.CategoryService;
import com.baizhi.serviceImpl.CategoryServiceImpl;
import com.baizhi.entity.Category;
import org.apache.struts2.ServletActionContext;


public class CategoryAction {
	//不需要收集参数
	public String execute(){
		CategoryService cs=new CategoryServiceImpl();
		List<Category> list = cs.queryAll();
		//把list存入resquest中
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("list", list);
		
		return "CateAction";
		
	}
}
