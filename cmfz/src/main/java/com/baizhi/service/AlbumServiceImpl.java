package com.baizhi.service;

import com.baizhi.dao.AlbumMapper;
import com.baizhi.entity.Album;
import com.baizhi.entity.Banner;
import org.hibernate.validator.constraints.br.TituloEleitoral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Service
@TituloEleitoral
public class AlbumServiceImpl implements  AlbumService{
   @Autowired
    AlbumMapper albumMapper;
    //分页
    @Override
    public Map<String, Object> showPage(Integer page, Integer rows) {
        //准备返回客户端的数据
        Map<String, Object> maps = new HashMap<>();
        //当前页号
        maps.put("page", page);
        Integer totalCount = albumMapper.selectTotalCount();
        //总条数
        maps.put("records", totalCount);
        //总页数
        Integer pageCount = 0;
        //总页数
        if (totalCount % rows != 0) {
            pageCount = totalCount / rows + 1;
        } else {
            pageCount = totalCount / rows;
        }
        maps.put("total", pageCount);
        //当前数据内容
        List<Album> employees = albumMapper.showAllByPage(page, rows);
        maps.put("rows", employees);
        return maps;
    }
    //添加
    @Override
    public String insert(Album album) {
        String id = UUID.randomUUID().toString().replace("_", "");
        album.setId(id);
        album.setCreateDate(new Date());
        albumMapper.insert(album);
        return album.getId();
    }
    //上传
    @Override
    public void upload(MultipartFile coverPic, HttpSession session, String albumId) {
        //判断上传文件夹是否存在
        String realPath = session.getServletContext().getRealPath("/img");
        File file = new File(realPath);
        if (!file.exists()){
            file.mkdirs();
        }
        String originalFilename = coverPic.getOriginalFilename();
        String str = new Date().getTime() + "_" + originalFilename;
        try {
            coverPic.transferTo(new File(realPath,str));
            Album album=new Album();
            album.setId(albumId);
            album.setCoverPic(str);
            albumMapper.updateByPrimaryKeySelective(album);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //删除数组
    @Override
    public void deleteByid(String[] id) {
        albumMapper.deleteByPrimaryKey(id);
    }
    //修改
    @Override
    public String update(Album album) {
        if (album.getCoverPic().equals("") || album.getCoverPic()==null){
            Album album1 = albumMapper.selectByPrimaryKey(album.getId());
            album.setCoverPic(album1.getCoverPic());
            //System.out.println(album1.getCoverPic());

        }/*else{
            albumMapper.updateByPrimaryKey(album);
        }*/
        albumMapper.updateByPrimaryKey(album);
        return album.getId();
    }
}
