package com.baizhi.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.baizhi.dao.BookDao;
import com.baizhi.Service.BookService;
import com.baizhi.util.MybatisUtil;
import com.baizhi.entity.Book;
import org.apache.ibatis.session.SqlSession;
import org.apache.struts2.ServletActionContext;



public class BookServiceImpl implements BookService {
	//图书管理
	@Override
	public List<Book> QueryAllBook() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		BookDao mapperDao = sqlSession.getMapper(BookDao.class);
		//BookDao mapperDao = (BookDao) MybatisUtil.getMapper(BookDao.class);
		List<Book> list = mapperDao.QueryAllBook();
		
		MybatisUtil.close();
		return list;
	}
	//删除
	@Override
	public void deleteAllbook(String id) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		BookDao mapperDao = sqlSession.getMapper(BookDao.class);
		//BookDao mapperDao = (BookDao) MybatisUtil.getMapper(BookDao.class);
	try {
		mapperDao.deleteAllbook(id);
		MybatisUtil.commit();
	} catch (Exception e) {
		MybatisUtil.rollback();
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		MybatisUtil.close();
	}
		
	}
	//添加
	@Override
	public void insertAllbook(Book book) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		BookDao mapperDao = sqlSession.getMapper(BookDao.class);
	//BookDao mapperDao = (BookDao) MybatisUtil.getMapper(BookDao.class);
	String id = UUID.randomUUID().toString();
	book.setId(id);
	
	mapperDao.insertAllbook(book);
	MybatisUtil.commit();
	MybatisUtil.close();
	}
	
	
	
	//模糊查询
	@Override
	public List<Book> likebookAll(String key, String content) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		BookDao mapperDao = sqlSession.getMapper(BookDao.class);
		//BookDao mapperDao = (BookDao) MybatisUtil.getMapper(BookDao.class);
		List<Book> list = mapperDao.likebookAll(key, content);
		MybatisUtil.close();
		return list;
	}
	
	//查询 回显
	@Override
	public Book selectbook(String id) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		BookDao mapperDao = sqlSession.getMapper(BookDao.class);
		//BookDao mapperDao = (BookDao) MybatisUtil.getMapper(BookDao.class);
		Book book = mapperDao.selectbook(id);
		MybatisUtil.close();
		return book;
	}
	//修改
	@Override
	public void updateAllbook(Book book) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		BookDao mapperDao = sqlSession.getMapper(BookDao.class);
	//BookDao mapperDao = (BookDao) MybatisUtil.getMapper(BookDao.class);
	mapperDao.updateAllbook(book);
	MybatisUtil.commit();
	MybatisUtil.close();
	}
	
	
	
	
	
								//front
	
	//编辑推荐
	@Override
	public List<Book> recommendBook() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		BookDao bdDao = sqlSession.getMapper(BookDao.class);
		//BookDao bdDao = (BookDao) MybatisUtil.getMapper(BookDao.class);
		//查询出所有书籍
		List<Book> list = bdDao.recommendBook();
		List<Book> recommendAllBook=new ArrayList<Book>();
		List<Book> recommendBook=new ArrayList<Book>();
		//遍历当前书籍集合
		for(Book book:list){
			if(!book.getEditorRecommend().equals("编辑没有推荐")){
				recommendAllBook.add(book);
			}
		}
		int a=(int)(Math.random()*recommendAllBook.size());
		int b=(int)(Math.random()*recommendAllBook.size());
		while(a==b){
			b=(int)(Math.random()*recommendAllBook.size());		
		}
		recommendBook.add(recommendAllBook.get(a));
		recommendBook.add(recommendAllBook.get(b));	
		MybatisUtil.close();
		return recommendBook;
	}
	
	
	
	
	
	//热销图书
	@Override
	public List<Book> hotBook() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		BookDao bdDao = sqlSession.getMapper(BookDao.class);
		//BookDao bdDao = (BookDao) MybatisUtil.getMapper(BookDao.class);
		List<Book> list = bdDao.hotBook();
		MybatisUtil.close();
		return list;
	}
	//新书上架
	@Override
	public List<Book> newBook() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		BookDao bdDao = sqlSession.getMapper(BookDao.class);
		//BookDao bdDao = (BookDao) MybatisUtil.getMapper(BookDao.class);
		List<Book> list = bdDao.newBook();
		MybatisUtil.close();
		return list;
	}
	//新书热卖
	@Override
	public List<Book> hotBoardBook() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		BookDao bdDao = sqlSession.getMapper(BookDao.class);
		//BookDao bdDao = (BookDao) MybatisUtil.getMapper(BookDao.class);
		List<Book> list = bdDao.hotBoardBook();
		MybatisUtil.close();
		return list;
	}
	
	
	
	//分页查询
	@Override
	public List<Book> selectfidsid(String fid, String sid, int currentPage) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		BookDao bdDao = sqlSession.getMapper(BookDao.class);
		//BookDao bdDao = (BookDao) MybatisUtil.getMapper(BookDao.class);
		//图书总量
		Integer count = bdDao.totalCount(fid, sid);
		//总页数
		int totalPage=(count%3==0)?count/3:count/3+1;
		//当前页数
		//每页多少条
		int a=3;
		//从哪查
		int begin=(currentPage-1)*3+1;
		//到哪结束
		int end=3*currentPage;
		ServletActionContext.getRequest().setAttribute("totalPage", totalPage);
		List<Book> list=bdDao.selectfidsid(fid, sid, begin, end);
		
		return list;
	}
	
	
	
	//查询所有
	@Override
	public Book selectBookQuery(String id) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		BookDao bdDao = sqlSession.getMapper(BookDao.class);
		//BookDao bdDao = (BookDao) MybatisUtil.getMapper(BookDao.class);
		Book book = bdDao.selectBookQuery(id);
		return book;
	}
	
	
}	

