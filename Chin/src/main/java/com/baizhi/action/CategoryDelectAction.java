package com.baizhi.action;


import com.baizhi.Service.CategoryService;
import com.baizhi.serviceImpl.CategoryServiceImpl;
import com.baizhi.entity.Category;

public class CategoryDelectAction {
	private String id;
	private String levels;
	private Category category;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLevels() {
		return levels;
	}
	public void setLevels(String levels) {
		this.levels = levels;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String execute(){
		CategoryService cs=new CategoryServiceImpl();
		cs.CategoryDelect(category);
		
		return "CateDelect";
		
		
	}
}
