package com.baizhi.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.baizhi.Service.UserService;
import com.baizhi.serviceImpl.UserServiceImpl;
import com.baizhi.util.MybatisUtil;
import com.baizhi.entity.User;
import org.apache.struts2.ServletActionContext;




public class UserAction {
	private String email;
	private String password;
	private User user;
	private String inputCode;
	
	//验证码
	private String captcha;

	
	public String getInputCode() {
		return inputCode;
	}
	public void setInputCode(String inputCode) {
		this.inputCode = inputCode;
	}
	public String getCaptcha() {
		return captcha;
	}
	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String queryAllUser(){
	//调用订单业务层查询所有订单集合
		 UserService us= (UserService) new UserServiceImpl();
		 List<User> list = us.queryAllUser();
		//把集合存到request
		 ServletActionContext.getRequest().setAttribute("list", list);
		//流程跳转
		return "Userquery";
	}
	//状态修改
	public String queryiduser(){
		UserService us= (UserService) new UserServiceImpl();
		
		User useremail = us.useremail(email);
		//System.out.println(useremail);
		String status = useremail.getStatus();
		if("正常".equals(status)){
			useremail.setStatus("冻结");
			//System.out.println("现在是==="+useremail);
			us.update(useremail);
		}else{			
			useremail.setStatus("正常");
			//System.out.println("我是==="+useremail);
			us.update(useremail);
	}
		return "statu";			
	}
	//登录 front
	public String loginfront(){
		UserService us= (UserService) new UserServiceImpl();
		try {
			User selectAll = us.selectAll(user.getEmail(), user.getPassword());
			HttpSession session = ServletActionContext.getRequest().getSession();
			session.setAttribute("loginUser", selectAll);					
		} catch (Exception e) {
			e.printStackTrace();
			String message = e.getMessage();
			ServletActionContext.getRequest().setAttribute("message", message);
			return "login";
		}
		return "loginfront";
	}
	
	//退出
	public String logou(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.invalidate();
		return "logou";
		
		
	}
	
		/*public String captcha() throws IOException{
		
		//1 生成随机字符串
		String code = SecurityCode.getSecurityCode();
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("captcha", code);
		//2生成验证码
		BufferedImage image = SecurityImage.createImage(code);
		//3 把响应的验证码图片输出
		HttpServletResponse response = ServletActionContext.getResponse();
		ServletOutputStream out= response.getOutputStream();
		ImageIO.write(image, "png", out);
		return null;
	}*/
	
	//注册
	public String register(){		
		UserService us= (UserService) new UserServiceImpl();
		us.insertUser(user);
		ServletActionContext.getRequest().getSession().setAttribute("emailcode", "123456");
		
			return "register";
		
	
	}
	//验证邮箱
	public String update1(){
		UserService us= (UserService) new UserServiceImpl();
		User user1 = (User) ServletActionContext.getRequest().getSession().getAttribute("loginUser");
		us.update1(user1, inputCode);
		MybatisUtil.commit();
		return "ok";
	}
	
}
	

