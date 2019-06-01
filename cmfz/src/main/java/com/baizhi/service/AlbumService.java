package com.baizhi.service;

import com.baizhi.entity.Album;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.Map;

public interface AlbumService {
    //分页的Service  处理业务
    public Map<String,Object> showPage(Integer page, Integer rows);
    //添加
    public String insert(Album album);
    //上传
    public void upload(MultipartFile coverPic, HttpSession session, String albumId);
    //删除数组
    public void deleteByid(String[] id);
    //修改
    public String update(Album album);

}
