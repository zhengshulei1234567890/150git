package com.baizhi.entity;

import java.io.Serializable;

public class Admin implements Serializable{
	private String password;
	private String id;
	private String username;
	
	public Admin(){}
	public Admin(String password, String id, String username) {
		super();
		this.password = password;
		this.id = id;
		this.username = username;
	}
	@Override
	public String toString() {
		return "Admin [password=" + password + ", id=" + id + ", username="
				+ username + "]";
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	

}
