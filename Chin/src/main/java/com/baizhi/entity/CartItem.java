package com.baizhi.entity;

import java.io.Serializable;

public class CartItem implements Serializable{
	private Book book;//图书对象
	private Integer count;//购买数量
	private Double littelPrice;//小计
	public CartItem() {
		super();
	}
	public CartItem(Book book, Integer count, Double littelPrice) {
		super();
		this.book = book;
		this.count = count;
		this.littelPrice = littelPrice;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Double getLittelPrice() {
		return littelPrice;
	}
	public void setLittelPrice(Double littelPrice) {
		this.littelPrice = littelPrice;
	}
	@Override
	public String toString() {
		return "CartItem [book=" + book + ", count=" + count + ", littelPrice="
				+ littelPrice + "]";
	}
	 
	
}
