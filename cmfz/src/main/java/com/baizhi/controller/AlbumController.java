package com.baizhi.controller;

import com.baizhi.entity.Album;
import com.baizhi.entity.Banner;
import com.baizhi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/Album")
public class AlbumController {
    @Autowired
    AlbumService albumService;

    //分页
    @RequestMapping("/pager")
    public @ResponseBody
    Map<String, Object> showAllByPage(Integer page, Integer rows) {
        Map<String, Object> map = albumService.showPage(page, rows);
        return map;
    }
    //添加
    @RequestMapping("edit")
    public Map<String, String> insert(Album album,String oper,String[] id){
        HashMap<String, String> map = new HashMap<>();
        if (oper.equals("add")){
            String s = albumService.insert(album);
            map.put("msg","添加成功");
            map.put("albumId",s);
        }else if (oper.equals("edit")){
            //albumService.update(album);
            String coverPic = album.getCoverPic();
            if (coverPic.equals("")){
                map.put("albumId","");
                map.put("msg","修改成功");
                albumService.update(album);
            }else {
                map.put("albumId",album.getId());
                map.put("msg","修改成功");
                albumService.update(album);
            }
        }else if (oper.equals("del")){
            albumService.deleteByid(id);
            map.put("msg","删除成功");

        }
        return map;
    }

    //上传
    @RequestMapping("/upload")
    public void upload(MultipartFile coverPic, HttpSession session, String albumId) {
        albumService.upload(coverPic, session, albumId);

    }


}
