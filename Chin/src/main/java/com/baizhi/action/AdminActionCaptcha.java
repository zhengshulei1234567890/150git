package com.baizhi.action;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.baizhi.util.SecurityCode;
import com.baizhi.util.SecurityImage;
import org.apache.struts2.ServletActionContext;



public class AdminActionCaptcha {
	public String captcha() throws IOException{
		
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
	}
}
