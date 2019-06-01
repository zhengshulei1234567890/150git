package com.baizhi.entity;

import java.io.Serializable;
import java.util.List;



public class Address implements Serializable{
	private String id;
	private String name;
	private String local;
	private String zip_code;//zipCode
	private String phone;
	private String user_id;//userId
	private User user;
	private List<Orders> orders;
	public Address() {
		super();
	}
	public Address(String id, String name, String local, String zip_code,
			String phone, String user_id, User user, List<Orders> orders) {
		super();
		this.id = id;
		this.name = name;
		this.local = local;
		this.zip_code = zip_code;
		this.phone = phone;
		this.user_id = user_id;
		this.user = user;
		this.orders = orders;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getZip_code() {
		return zip_code;
	}
	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Orders> getOrders() {
		return orders;
	}
	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", name=" + name + ", local=" + local
				+ ", zip_code=" + zip_code + ", phone=" + phone + ", user_id="
				+ user_id + ", user=" + user + ", orders=" + orders + "]";
	}
	
}
