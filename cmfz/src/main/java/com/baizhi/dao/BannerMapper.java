package com.baizhi.dao;

import com.baizhi.entity.Banner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BannerMapper {
    //删除
    public void deleteByPrimaryKey(String[] id);
    //添加
    public void  insert(Banner record);

    public void  insertSelective(Banner record);

    Banner selectByPrimaryKey(String id);
    //上传修改
    public void  updateByPrimaryKeySelective(Banner record);
    //修改
    public void  updateByPrimaryKey(Banner record);


    //通过分页进行查询                      // 当前页号       每页显示的条数
    public List<Banner> showAllByPage(@Param("page") Integer page, @Param("rows") Integer rows);
    //查询总条数
    public  Integer  selectTotalCount();
}