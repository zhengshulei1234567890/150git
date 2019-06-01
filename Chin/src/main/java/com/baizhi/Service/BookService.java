package com.baizhi.Service;

import java.util.List;

import com.baizhi.entity.Book;
import org.apache.ibatis.annotations.Param;





public interface BookService {
	//图书管理
	public List<Book> QueryAllBook();
	//删除
	public void deleteAllbook(String id);
	
	//添加
	public void insertAllbook(Book book);

	//查询  (修改回显)
	public Book selectbook(String id);

	//修改
	public void updateAllbook(Book book);
	//模糊查询
	public List<Book> likebookAll(@Param("key") String key, @Param("content") String content);

					//front
			
			//编辑推荐
			public List<Book> recommendBook();
			//热销图书
			public List<Book> hotBook();
			//新书上架
			public List<Book> newBook();
			//新书热卖
			public List<Book> hotBoardBook();




			//一级页面及二级所有分类
			public List<Book> selectfidsid(String fid, String sid, int currentPage);


			//查询所有
			public Book selectBookQuery(String id);	



}

