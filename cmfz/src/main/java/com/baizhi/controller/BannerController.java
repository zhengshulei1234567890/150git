package com.baizhi.controller;

import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/banner")
public class BannerController {
    @Autowired
    BannerService bannerService;

    //查询
   /* @RequestMapping("/select")
    public List<Banner> selectquery() {
        List<Banner> list = bannerService.queryAll();
        System.out.println(list);
        return list;
    }*/

    //添加
    @RequestMapping("/edit")
    public Map<String, String> insert(Banner banner, String oper, String[] id) {
        HashMap<String, String> map = new HashMap<>();
        if (oper.equals("add")) {
            String s = bannerService.insert(banner);
            map.put("msg", "添加成功");
            map.put("bannerId", s);
        }else if (oper.equals("edit")){
            String imgPic = banner.getImgPic();
            if (imgPic.equals("")){
                map.put("bannerId","");
                map.put("msg","修改成功");
                bannerService.update(banner);
            }else {
                map.put("bannerId",banner.getId());
                map.put("msg","修改成功");
                bannerService.update(banner);
            }

        }else if (oper.equals("del")){
            bannerService.deleteByid(id);
            map.put("msg","删除信息");
        }
        return map;
    }


    //分页
    @RequestMapping("/pager")
    public @ResponseBody
    Map<String, Object> showAllByPage(Integer page, Integer rows) {
        Map<String, Object> map = bannerService.showPage(page, rows);
        return map;
    }

    //上传
    @RequestMapping("/upload")
    public void upload(MultipartFile imgPic, HttpSession session, String bannerId) {
        bannerService.upload(imgPic, session, bannerId);

    }
}
