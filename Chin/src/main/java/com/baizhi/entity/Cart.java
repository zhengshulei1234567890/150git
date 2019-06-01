package com.baizhi.entity;

import java.io.Serializable;
import java.util.Map;

public class Cart implements Serializable{
	private Double totalPrice;//商品总价
	private Double savePrice;//节省的金钱
	private Map<String,CartItem> cartItems;//购物车项集合  Map
	public Cart() {
		super();
	}
	public Cart(Double totalPrice, Double savePrice,
			Map<String, CartItem> cartItems) {
		super();
		this.totalPrice = totalPrice;
		this.savePrice = savePrice;
		this.cartItems = cartItems;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Double getSavePrice() {
		return savePrice;
	}
	public void setSavePrice(Double savePrice) {
		this.savePrice = savePrice;
	}
	public Map<String, CartItem> getCartItems() {
		return cartItems;
	}
	public void setCartItems(Map<String, CartItem> cartItems) {
		this.cartItems = cartItems;
	}
	@Override
	public String toString() {
		return "Cart [totalPrice=" + totalPrice + ", savePrice=" + savePrice
				+ ", cartItems=" + cartItems + "]";
	}
	
}
