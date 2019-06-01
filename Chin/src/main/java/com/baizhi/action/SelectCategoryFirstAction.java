package com.baizhi.action;

import java.util.List;

import com.baizhi.Service.CategoryService;
import com.baizhi.serviceImpl.CategoryServiceImpl;
import com.baizhi.entity.Category;
import org.apache.struts2.ServletActionContext;



public class SelectCategoryFirstAction {
	public String QueryFirst(){
	//调用业务方法
		CategoryService cs=new CategoryServiceImpl();
		List<Category> list=cs.queryFirst();
		//把list存入request
		//HttpServletRequest request = ServletActionContext.getRequest();
		ServletActionContext.getRequest().getSession().setAttribute("list",list);
		//流程跳转
		return "CategoryFirstSelert";
		
	}
	//二级类别查询
	public String querysecond(){
		//调用业务方法
		CategoryService cs=new CategoryServiceImpl();
		List<Category> list=cs.querysecond();
		ServletActionContext.getRequest().getSession().setAttribute("list",list);
		
		return "second";
	
	
	}
}
