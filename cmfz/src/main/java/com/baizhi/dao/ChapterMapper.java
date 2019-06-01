package com.baizhi.dao;

import com.baizhi.entity.Chapter;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ChapterMapper {
    //删除
    int deleteByPrimaryKey(String[] id);
    //添加
    int insert(Chapter record);

    int insertSelective(Chapter record);
   //上传
    int updateByPrimaryKeySelective(Chapter record);
    //修改
    int updateByPrimaryKey(Chapter record);


    //通过分页进行查询                      // 当前页号       每页显示的条数
    public List<Chapter> selectByPrimaryKey(@Param("page") Integer page, @Param("rows") Integer rows, @Param("albumId")String albumId);
    //查询总条数
    public  Integer  selectTotalCount();
}