package com.baizhi.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.baizhi.Service.AdminService;
import com.baizhi.serviceImpl.AdminServiceImpl;
import com.baizhi.entity.Admin;
import org.apache.struts2.ServletActionContext;


public class AdminActionLogin {
	private String username;
	private String password;
	private String captcha;
	
	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String login(){
		
		AdminService as= (AdminService) new AdminServiceImpl();
		Admin Admin = as.findLogin(username, password);
		//System.out.println("刚发的"+Admin);
		HttpServletRequest request = ServletActionContext.getRequest();
		//验证码
		HttpSession session2 = request.getSession();
		Object captchaAction = session2.getAttribute("captcha");
		
		//登录
		HttpSession session =request.getSession();
		session.setAttribute("Admin", Admin);
		
		//验证码
		if(captchaAction.equals(captcha)){
			//System.out.println("第三方公司打工"+captchaAction.equals(captcha));
		//登录
			
		if(Admin != null){
			return "loginAction";
		}
		return "login";
	}else{
		return "login";
	}
	}
}

