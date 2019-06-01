package com.baizhi.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;

@Controller
@RequestMapping("/upload")
public class Uploadcontroller {


        @RequestMapping("/u")
    public String upload(MultipartFile upload, HttpSession session)throws Exception{
            //获取目标文件夹upload的绝对路径
            ServletContext servletContext = session.getServletContext();
            String realPath = servletContext.getRealPath("/upload");
            //创建一个和上传文件命名相同的文件 该文件没有内容
            File file = new File(realPath + "/" + upload.getOriginalFilename());
            //把上传的文件内容  传输到空的文件中
            upload.transferTo(file);
            return "uploadOk";
        }
}
