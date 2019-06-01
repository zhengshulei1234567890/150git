package com.baizhi.service;


import com.baizhi.entity.Chapter;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

public interface ChapterService {

    //分页的Service  处理业务,
    public Map<String,Object> showPage(Integer page, Integer rows,String albumId);
    //添加
    public String insert(Chapter chapter);
    //删除
    public void  deleteByPrimaryKey(String[] id);
    //修改
   public String  updateByPrimaryKey(Chapter chapter);
    //上传修改
    public void uploadChapter(MultipartFile path, HttpSession session, String chapterId);
    //下载
    public void downLoadAudio(String audioName, HttpServletResponse response,HttpSession session);

}
