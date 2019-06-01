package com.baizhi.entity;

import java.io.Serializable;
import java.util.Date;

public class Item implements Serializable{
	private String id;
	private String bookId;
	private Integer count;
	private Date createDate;
	private String OrderId;	
	private Orders order;
	private Book book;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getOrderId() {
		return OrderId;
	}
	public void setOrderId(String orderId) {
		OrderId = orderId;
	}
	public Orders getOrder() {
		return order;
	}
	public void setOrder(Orders order) {
		this.order = order;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", bookId=" + bookId + ", count=" + count
				+ ", createDate=" + createDate + ", OrderId=" + OrderId
				+ ", order=" + order + ", book=" + book + "]";
	}
	public Item(String id, String bookId, Integer count, Date createDate,
			String orderId, Orders order, Book book) {
		super();
		this.id = id;
		this.bookId = bookId;
		this.count = count;
		this.createDate = createDate;
		OrderId = orderId;
		this.order = order;
		this.book = book;
	}
	public Item() {
		super();
	}
	
}
