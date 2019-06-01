package com.baizhi.dao;

import com.baizhi.entity.Category;

import java.util.List;



public interface CategoryDao {
	//类别管理
	public List<Category> queryAll();
	//一级页面
	public void categoryFirst(Category cate);
	//一级页面查询  
	public List<Category> queryFirst();
	
	//二级页面查询 (book)
	public List<Category> querysecond();
	
	
	//二级页面添加
	public void categorySecond(Category cate);
	//删除
	public void categoryDelect(Category category);
	//查询
	public 	List<Category> categorySelertSecond(Category category);

				//front
	//分类浏览
	public List<Category> queryCategoryAll();
	
	
	//查询一级页面及所有二级页面
	public Category categoryFid(String fid);
	
}
