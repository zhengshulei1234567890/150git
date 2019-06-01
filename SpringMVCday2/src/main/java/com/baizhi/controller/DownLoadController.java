package com.baizhi.controller;


import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;

@Controller
@RequestMapping("/download")
public class DownLoadController {


    @RequestMapping("/d")
    public ResponseEntity<byte[]> download(String filename, HttpSession session)throws Exception{
        //获取下载文件所在的目录
        ServletContext servletContext = session.getServletContext();
        String realPath = servletContext.getRealPath("/upload");
        //代表下载的目标文件
        File file = new File(realPath + "/" + filename);
        //把下载的文件转换为字节数组
        byte[] bytes = FileUtils.readFileToByteArray(file);
        //设置Http协议请球头
        HttpHeaders httpHeaders = new HttpHeaders();
        //解决下载过后的文件名乱码问题
        String downname= new String(filename.getBytes("UTF-8"),"iso-8859-1");
        //设置下载时打开的方式
        httpHeaders.setContentDispositionFormData("attachment",filename);
        //设置下载方式为二进制流的形式
        httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(bytes,httpHeaders, HttpStatus.CREATED);

    }
}
