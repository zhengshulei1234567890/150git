package com.baizhi.dao;

import java.util.List;

import com.baizhi.entity.Book;
import org.apache.ibatis.annotations.Param;


public interface BookDao {
	public List<Book> BookFind(String id);
	//图书管理
	public List<Book> QueryAllBook();
	
	//图书管理   删除
	public void deleteAllbook(String id);
	
	//添加
	public void insertAllbook(Book book);
	
	//查询(修改回显)
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
	public List<Book> selectfidsid(@Param("fid") String fid, @Param("sid") String sid, @Param(value = "begin") int begin, @Param(value = "end") int end);
	
	//查询某个类别下图书总条数
	public Integer totalCount(@Param("fid") String fid, @Param("sid") String sid);
	
	//查询所有
	public Book selectBookQuery(String id);
	
	public void updateBook(@Param(value = "id")String id, @Param(value = "count")int count);
}
