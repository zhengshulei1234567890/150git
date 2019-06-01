package com.baizhi.service;

import com.baizhi.dao.BannerMapper;
import com.baizhi.entity.Banner;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Service
@Transactional
public class BannerServiceImpl implements BannerService {
    @Autowired
    BannerMapper bannerMapper;


    //添加
    @Override
    public String  insert(Banner banner) {
        String id = UUID.randomUUID().toString().replace("-","");
        banner.setId(id);
        banner.setCreateDate(new Date());
        bannerMapper.insert(banner);
        return banner.getId();
    }

    //分页
    @Override
    public Map<String, Object> showPage(Integer page, Integer rows) {
        //准备返回客户端的数据
        Map<String, Object> maps = new HashMap<>();
        //当前页号
        maps.put("page", page);
        Integer totalCount = bannerMapper.selectTotalCount();
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
        List<Banner> employees = bannerMapper.showAllByPage(page, rows);
        maps.put("rows", employees);
        return maps;
    }


    //修改
    @Override
    public String update(Banner banner) {
        if (banner.getImgPic().equals("") || banner.getImgPic()==null){
            Banner banner1 = bannerMapper.selectByPrimaryKey(banner.getId());
            banner.setImgPic(banner1.getImgPic());
            bannerMapper.updateByPrimaryKey(banner);
        }else{
            bannerMapper.updateByPrimaryKey(banner);
        }

        return banner.getId();
    }

    //上传
    @Override
    public void upload(MultipartFile imgPic, HttpSession session,String bannerId) {
        //判断上传文件夹是否存在
        String realPath = session.getServletContext().getRealPath("/img");
        File file = new File(realPath);
        if (!file.exists()){
            file.mkdirs();
        }
        String originalFilename = imgPic.getOriginalFilename();
        String str = new Date().getTime() + "_" + originalFilename;
        try {
            imgPic.transferTo(new File(realPath,str));
            Banner banner = new Banner();
            banner.setId(bannerId);
            banner.setImgPic(str);
            bannerMapper.updateByPrimaryKeySelective(banner);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //删除数组
    @Override
    public void deleteByid(String[] id) {
        bannerMapper.deleteByPrimaryKey(id);
    }
}



