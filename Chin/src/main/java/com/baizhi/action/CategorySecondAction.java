package com.baizhi.action;


import com.baizhi.Service.CategoryService;
import com.baizhi.serviceImpl.CategoryServiceImpl;
import com.baizhi.entity.Category;

public class CategorySecondAction {
	private Category category;

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	public String CategorySecond(){
		//调用业务
		CategoryService cs=new CategoryServiceImpl();
		
		cs.CategorySecond(category);
		//System.out.println("打印"+category);
		return "CategorySecond";
		
		
	}
}
