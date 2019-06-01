package com.baizhi.controller;

import com.baizhi.entity.Article;
import com.baizhi.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("Article")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @RequestMapping("getAllarticle")
    public Map<String,Object> getAllarticle(Integer page,Integer rows){
        Map<String, Object> map = articleService.selectByPrimaryKey(page, rows);
        return map;
    }
    //添加
    @RequestMapping("/edit")
    public Map<String, String> edit(Article article){
        articleService.insert(article);
        HashMap<String, String> map = new HashMap<>();
        //map.put("msg", "添加成功");
        return map;
    }
    //修改
    @RequestMapping("/update")
    public void update(Article article){

        articleService.updateByPrimaryKeySelective(article);
    }
    //删除
    @RequestMapping("/delete")
    public void delete(String[] id){
        articleService.deleteByPrimaryKey(id);

    }
}
