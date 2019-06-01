package com.baizhi.dao;

import com.baizhi.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleMapper {
    //删除
    int deleteByPrimaryKey(String[] id);

    //添加
    int insert(Article record);

    int insertSelective(Article record);
    //分页
    List<Article> selectByPrimaryKey(@Param("start") Integer start, @Param("rows") Integer rows);
    Integer getRecords();
    //修改
    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKey(Article record);
}