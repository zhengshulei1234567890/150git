package com.baizhi.controller;

import org.apache.commons.io.FilenameUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.SimpleFormatter;

@RestController
@RequestMapping("/kindeditor")
public class kindeditorController {



    @RequestMapping("uploading")
    public Map<String,Object> uploading(HttpServletRequest request, MultipartFile img) throws IOException {
        Map<String,Object> map=new HashMap<>();
        String realPath = request.getSession().getServletContext().getRealPath("upload/img");
        File file = new File(realPath);
        if (! file.exists()){
            file.mkdirs();
        }
        String originalFilename = img.getOriginalFilename();
        String s = new Date().getTime() + "_" + originalFilename;
        img.transferTo(new File(realPath,s));
        map.put("error",0);

        String scheme = request.getScheme();
        InetAddress localHost = InetAddress.getLocalHost();
        String s1 = localHost.toString();
        String localhost = s1.split("/")[1];
        int serverPort = request.getServerPort();//端口号
        String contextPath = request.getContextPath();
        String url = scheme + "://" + localhost + ":" + serverPort + contextPath + "/upload/img/" + s;
        map.put("url",url);
        return  map;
    }


    @RequestMapping("getAll")
    public Map<String ,Object> getAll(HttpServletRequest request) throws UnknownHostException {
        Map<String,Object> map=new HashMap<>();
        String realPath = request.getSession().getServletContext().getRealPath("/upload/img/");
        File file = new File(realPath);
        ArrayList<Object> list = new ArrayList<>();
        String[] imgs = file.list();
        for (String img : imgs) {
            HashMap<Object, Object> map1 = new HashMap<>();
            map1.put("is_dir",false);
            map1.put("has_file",false);
            File file1 = new File(realPath,img);
            long length = file1.length();
            map1.put("filesize",length);
            map1.put("dir_path","");
            map1.put("is_photo",true);
            String extension = FilenameUtils.getExtension(img);
            map1.put("filetype",extension);
            map1.put("filename",img);
            String s = img.split("_")[0];
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
            long lt = new Long(s);
            Date date = new Date(lt);
            String format = simpleDateFormat.format(date);
            map1.put("datatime",format);
            list.add(map1);
        }
        map.put("file_list",list);
        map.put("moveup_dir_path","");
        String scheme = request.getScheme();
        InetAddress localHost = InetAddress.getLocalHost();
        String s1 = localHost.toString();
        String localhost = s1.split("/")[1];

        int serverPort = request.getServerPort();//端口号
        String contextPath = request.getContextPath();
        String url = scheme + "://" + localhost + ":" + serverPort + contextPath + "/upload/img/";
        map.put("current_url",url);
        int length = imgs.length;
        map.put("total_count",length);
        return map;
    }

    @RequestMapping("/addkindeditor")
    public void addkindeditor(String content){
        System.out.println(content);
    }
}
