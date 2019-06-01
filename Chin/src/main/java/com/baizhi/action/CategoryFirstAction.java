package com.baizhi.action;

import com.baizhi.Service.CategoryService;
import com.baizhi.serviceImpl.CategoryServiceImpl;
import com.baizhi.entity.Category;


public class CategoryFirstAction {
	private Category category;
	
		public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

		
		public String CategoryFirst(){
			CategoryService cs=new CategoryServiceImpl();
			cs.CategoryFirst(category);
			return "CategoryFirst";
			
			
		}
		
		
}
