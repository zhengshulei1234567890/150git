package com.baizhi.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

public class TestController {
    @RequestMapping("first_page")
    public Map<String,Object> first_page(String all,String wen,String si,String ssyj,String xmfy){
        Map<String,Object> map=new HashMap<>();
        if (all !=null || si ==null || ssyj ==null){
            //返回错误信息 错误码 与 错误信息
        }else {
            if (all !=null){
                map.put("banner","轮播图集合");
                map.put("album","专辑集合");
                map.put("article","上师对你发布文章集合");
            }else if (wen != null){
               map.put("album","专辑集合");
            }else if (si !=null){
                if (ssyj !=null){
                    map.put("article","你的上师对你发布的文章集合");
                }else  if (xmfy != null){
                    map.put("article","所有上师的文章集合");
                }
            }
        }
        return null;
    }
}
