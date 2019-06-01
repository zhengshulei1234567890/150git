package com.baizhi.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
public class Orders implements Serializable{
	private String id;
	private String orderNo;
	private Integer total;
	private Date createDate;
	private String userId;
	private String addressid;
	private Address addr;
	private User user;
	private List<Item> items;
	public Orders(String id, String orderNo, Integer total, Date createDate,
			String userId, String addressid, Address addr, User user,
			List<Item> items) {
		super();
		this.id = id;
		this.orderNo = orderNo;
		this.total = total;
		this.createDate = createDate;
		this.userId = userId;
		this.addressid = addressid;
		this.addr = addr;
		this.user = user;
		this.items = items;
	}
	public Orders() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getAddressid() {
		return addressid;
	}
	public void setAddressid(String addressid) {
		this.addressid = addressid;
	}
	public Address getAddr() {
		return addr;
	}
	public void setAddr(Address addr) {
		this.addr = addr;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	@Override
	public String toString() {
		return "Orders [id=" + id + ", orderNo=" + orderNo + ", total=" + total
				+ ", createDate=" + createDate + ", userId=" + userId
				+ ", addressid=" + addressid + ", addr=" + addr + ", user="
				+ user + ", items=" + items + "]";
	}
	
	
}
