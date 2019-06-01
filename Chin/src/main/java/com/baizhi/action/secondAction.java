package com.baizhi.action;

import java.util.List;

import com.baizhi.Service.BookService;
import com.baizhi.Service.CategoryService;
import com.baizhi.serviceImpl.BookServiceImpl;
import com.baizhi.serviceImpl.CategoryServiceImpl;
import com.baizhi.entity.Book;
import com.baizhi.entity.Category;
import org.apache.struts2.ServletActionContext;



public class secondAction {
	private CategoryService cs=new CategoryServiceImpl();
	private BookService bs=new BookServiceImpl();
	private String fid;
	private String sid;
	private int currentPage;
	private Book book;
	private String id;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	//分页查询
	public String secondJsp(){
		Category category = cs.categoryFid(fid);
		ServletActionContext.getRequest().setAttribute("category", category);
		List<Book> list = bs.selectfidsid(fid, sid, currentPage);
		ServletActionContext.getRequest().setAttribute("list", list);
		return "second";
		
	}

	 public String selectBookQuery(){
		// BookService bs=new BookServiceImpl();
		 Book book = bs.selectBookQuery(id);
		 ServletActionContext.getRequest().setAttribute("book",book);
		return "selectBook";
		 
		 
		 
	 }
}
