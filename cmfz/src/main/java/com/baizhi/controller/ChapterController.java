package com.baizhi.controller;

import com.baizhi.entity.Album;
import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/chapter")
public class ChapterController {
    @Autowired
    ChapterService chapterService;
    //分页
    @RequestMapping("/pager")
    public @ResponseBody
    Map<String, Object> showAllByPage(Integer page, Integer rows,String albumId) {
        Map<String, Object> map = chapterService.showPage(page, rows,albumId);
        return map;
    }

    //添加
    @RequestMapping("edit")
    public Map<String, String> insert(Chapter chapter, String oper, String[] id ,String albumId){
        HashMap<String, String> map = new HashMap<>();
        if (oper.equals("add")){
            chapter.setAlbumId(albumId);
           // System.out.println(albumId);
            String s = chapterService.insert(chapter);
            map.put("chapterId",s);
            map.put("msg","添加成功");
        }else if (oper.equals("edit")){
            chapter.setAlbumId(albumId);
            String path = chapter.getPath();
            if (path.equals("")){
                map.put("chapterId","");
                map.put("msg","修改成功");
                chapterService.updateByPrimaryKey(chapter);
            }else {
                map.put("chapterId",chapter.getId());
                map.put("msg","修改成功");
                chapterService.updateByPrimaryKey(chapter);
            }


        }else if (oper.equals("del")){
           chapterService.deleteByPrimaryKey(id);
           map.put("msg","删除成功");

       }
        return map;
    }
    //上传
    @RequestMapping("upload")
    public Map<String,String> upload(MultipartFile path, HttpSession session, String chapterId) {
       chapterService.uploadChapter(path,session,chapterId);
        return null;
    }
    //下载
    @RequestMapping("/downLoadAudio")
    public void downLoadAudio(String audioName, HttpServletResponse response,HttpSession session){
        chapterService.downLoadAudio(audioName,response, session);
    }
}
