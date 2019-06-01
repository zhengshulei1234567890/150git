package com.baizhi.action;

import java.io.File;

import java.io.IOException;
import java.util.List;

import com.baizhi.Service.BookService;
import com.baizhi.Service.CategoryService;
import com.baizhi.serviceImpl.BookServiceImpl;
import com.baizhi.serviceImpl.CategoryServiceImpl;
import com.baizhi.entity.Book;
import com.baizhi.entity.Category;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;


public class BookAction {
	private String id;
	private Book book;
	private String key;
	private String content;
	 private File cover;
	 private String coverFileName;
	 private String coverContent;

	
	public File getCover() {
		return cover;
	}
	public void setCover(File cover) {
		this.cover = cover;
	}
	public String getCoverFileName() {
		return coverFileName;
	}
	public void setCoverFileName(String coverFileName) {
		this.coverFileName = coverFileName;
	}
	public String getCoverContent() {
		return coverContent;
	}
	public void setCoverContent(String coverContent) {
		this.coverContent = coverContent;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}


	//不需要收集参数
	public String BookAction(){
		BookService bs=new BookServiceImpl();
		List<Book> list = bs.QueryAllBook();
		ServletActionContext.getRequest().setAttribute("list", list);		
		return "bookquery";
		
	}
	
		//删除
	public String bookquerydelete(){
		BookService bs=new BookServiceImpl();
		bs.deleteAllbook(id);
		return "success";
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	//添加
	public String insertAlltbook(){
	BookService bs=new BookServiceImpl();
	String target=ServletActionContext.getServletContext().getRealPath("/back/img/"+coverFileName);	 
	File targetFile=new File(target);
		//判断此目录是否存在，如果不存在就创建
	try {
		//把当前文件存入目标目录
		FileUtils.copyFile(cover,targetFile);
		book.setCover(coverFileName);
	} catch (IOException e) {		
		e.printStackTrace();
	}
	bs.insertAllbook(book);
	return "insertAllbook";
	
	}
	//模糊查询
	public String likebookAll(){
		BookService bs=new BookServiceImpl();
		List<Book> list = bs.likebookAll(key, content);
		ServletActionContext.getRequest().setAttribute("list", list);
		return "likebook";	
	}
	
	//查询  修改回显
	public String selectbook(){
		CategoryService cs=new CategoryServiceImpl();
		BookService bs=new BookServiceImpl();
		
		Book book = bs.selectbook(id);
		
		List<Category> list2 = cs.querysecond();
		
		ServletActionContext.getRequest().setAttribute("book",book);
		ServletActionContext.getRequest().setAttribute("seconds",list2);
		return "selectbook";	
	}
	//修改
	public String updatebook(){
		BookService bs=new BookServiceImpl();
		if(cover != null){		
			String realPath=ServletActionContext.getServletContext().getRealPath("/back/img/"+coverFileName);	 
			File filePath = new File(realPath,coverFileName);		
			if(!filePath.getParentFile().exists()){
				filePath.getParentFile().mkdir();
			}
	
		try {
			//把当前文件存入目标目录
			FileUtils.copyFile(cover,filePath);
		} catch (IOException e) {		
			e.printStackTrace();
		}
		}
			book.setCover(coverFileName);
			bs.updateAllbook(book);
			return "updatebook";	
		}	
	
	
				//front


	public String queryMainBook(){
		BookService bs=new BookServiceImpl();
		CategoryService cs=new CategoryServiceImpl();
		//编辑推荐
		List<Book> recommendBook = bs.recommendBook();
		//热销图书
		List<Book> hotBook = bs.hotBook();
		//新书上架
		List<Book> newBook = bs.newBook();
		//新书热卖
		List<Book> hotBoardBook = bs.hotBoardBook();
		//分类管理
		List<Category> querCategoryAll = cs.queryCategoryAll();
		
		ServletActionContext.getRequest().setAttribute("recommends", recommendBook);
		ServletActionContext.getRequest().setAttribute("sales",hotBook );
		ServletActionContext.getRequest().setAttribute("newBook", newBook);
		ServletActionContext.getRequest().setAttribute("news", hotBoardBook);
		ServletActionContext.getRequest().setAttribute("firsts", querCategoryAll);
		return "querymain";		
	}
	
	
	
	
}


