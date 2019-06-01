package com.baizhi.service;

import com.baizhi.dao.ArticleMapper;
import com.baizhi.entity.Article;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class ArticleServiceImpl implements  ArticleService{
   @Autowired
  private ArticleMapper articleMapper;
   //分页
    @Override
    public Map<String,Object>  selectByPrimaryKey(Integer page, Integer rows) {
        Map<String,Object> map =new HashMap<>();
        Integer start=(page-1)*rows;
        List<Article> articles = articleMapper.selectByPrimaryKey(start, rows);
        Integer records = articleMapper.getRecords();
        int total = records % rows == 0 ? records / rows : records / rows + 1;
        map.put("page",page);
        map.put("records",records);
        map.put("total",total);
        map.put("rows",articles);
        return map;
    }

    @Override
    public String insert(Article article) {
        String id = UUID.randomUUID().toString().replace("_", "");
        article.setId(id);
        article.setCreateDate(new Date());
        articleMapper.insert(article);
        return article.getId();
    }
    //修改
    @Override
    public String updateByPrimaryKeySelective(Article article) {
        articleMapper.updateByPrimaryKeySelective(article);
        return  article.getId();
    }
    //删除
    @Override
    public void deleteByPrimaryKey(String[] id) {
        articleMapper.deleteByPrimaryKey(id);
    }
}
