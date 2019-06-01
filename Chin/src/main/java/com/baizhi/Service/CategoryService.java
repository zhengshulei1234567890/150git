package com.baizhi.Service;

import com.baizhi.entity.Category;

import java.util.List;



public interface CategoryService {
	//类别管理
	public List<Category> queryAll();
	//一级页面
	public void CategoryFirst(Category cate);
	//一级页面查询
	public List<Category> queryFirst();
	//二级页面查询 
	public List<Category> querysecond();
	//二级页面添加
	public void CategorySecond(Category cate);
	//删除
	public void CategoryDelect(Category category);



			//front
		//分类浏览
		public List<Category> queryCategoryAll();
		//查询一级分类及所有二级分类
		public Category categoryFid(String fid);
		
}
	

