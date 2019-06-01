package com.baizhi.service;

import com.baizhi.entity.Banner;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public interface BannerService {

    //添加
    public String  insert(Banner banner);
    //分页的Service  处理业务
    public Map<String,Object> showPage(Integer page, Integer rows);
    //修改
    public String update(Banner banner);
    //上传
    public void upload(MultipartFile imgPic, HttpSession session, String bannerId);
    //删除数组
    public void deleteByid(String[] id);

}
