package com.baizhi.controller;

import com.baizhi.util.ValidateImageCodeUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

//验证码
@Controller
@RequestMapping("code")
public class CodeController {

    @RequestMapping("getCode")
    public void getCode(HttpSession session, HttpServletResponse response){
    //1绘制图片中的数字
        String securityCode = ValidateImageCodeUtils.getSecurityCode();//数字
        //2 绘制验证码图片
        session.setAttribute("enCode",securityCode);
        BufferedImage image = ValidateImageCodeUtils.createImage(securityCode);
        ServletOutputStream outputStream=null;
        try {
            outputStream= response.getOutputStream();
            //3写出   图片    格式
            ImageIO.write(image,"png",outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                outputStream.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
