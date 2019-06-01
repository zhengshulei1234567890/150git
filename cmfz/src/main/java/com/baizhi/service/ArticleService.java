package com.baizhi.service;

import com.baizhi.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ArticleService {
    //分页
    Map<String,Object> selectByPrimaryKey(Integer page, Integer rows);
    //添加
    public String insert(Article article);
    //修改
    public String  updateByPrimaryKeySelective(Article article);
    //删除
     public void deleteByPrimaryKey(String[] id);
}
