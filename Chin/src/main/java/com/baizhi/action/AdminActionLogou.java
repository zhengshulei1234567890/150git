package com.baizhi.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

public class AdminActionLogou {
	//退出
	public String logou(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.invalidate();
		return "LogouAction";
		
		
	}
}
