package com.baizhi.entity;

import java.io.Serializable;
import java.util.List;

import oracle.net.jdbc.TNSAddress.Address;

public class User implements Serializable{
	private String id;
	private String email;
	private String password;
	private String salt;
	private String nickname;
	private String status;
	private String code;
	private List<Address> address;
	private List<Orders> orders;
	//private 
	public User() {
		super();
	}
	public User(String id, String email, String password, String salt,
			String nickname, String status, String code, List<Address> address,
			List<Orders> orders) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.salt = salt;
		this.nickname = nickname;
		this.status = status;
		this.code = code;
		this.address = address;
		this.orders = orders;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public List<Address> getAddress() {
		return address;
	}
	public void setAddress(List<Address> address) {
		this.address = address;
	}
	public List<Orders> getOrders() {
		return orders;
	}
	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password
				+ ", salt=" + salt + ", nickname=" + nickname + ", status="
				+ status + ", code=" + code + ", address=" + address
				+ ", orders=" + orders + "]";
	}
	
}
