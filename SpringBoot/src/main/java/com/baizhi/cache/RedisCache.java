package com.baizhi.cache;

import org.apache.ibatis.cache.Cache;
import org.springframework.boot.test.util.ApplicationContextTestUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import sun.awt.SunHints;

import javax.swing.*;
import java.util.concurrent.locks.ReadWriteLock;

public class RedisCache implements Cache {
    private String id;

    public RedisCache(String id) {
        System.out.println(id);
        this.id = id;
    }
      @Override
        public String getId() {
            return this.id;
        }
     //将查询结果  添加缓存  第一个参数 是key   第二个参数是查询结果
    @Override
    public void putObject(Object key, Object value) {
         //手动操作工厂获取相关对象
        StringRedisTemplate stringRedisTemplate = (StringRedisTemplate) ApplicationContextUtil.getBeanByClass(StringRedisTemplate.class);
        String serialize = SerializeUtils.serialize(value);
        stringRedisTemplate.opsForHash().put(id.toString(), key.toString(), serialize);
        System.out.println("存放缓存");
    }
//获取对应方法的缓存数据
    @Override
    public Object getObject(Object key) {
        System.out.println("获取缓存");
        StringRedisTemplate stringRedisTemplate = (StringRedisTemplate) ApplicationContextUtil.getBeanByClass(StringRedisTemplate.class);
      if (stringRedisTemplate.opsForHash().hasKey(id.toString(),key.toString())){
          String o =(String) stringRedisTemplate.opsForHash().get(id.toString(), key.toString());
          Object o1 = SerializeUtils.serializeToObject(o);
          return o1;
      }
        return null;
    }

    @Override
    public Object removeObject(Object o) {
        return null;
    }
    //增删改会调用clear
    @Override
    public void clear() {
        StringRedisTemplate stringRedisTemplate = (StringRedisTemplate) ApplicationContextUtil.getBeanByClass(StringRedisTemplate.class);
        stringRedisTemplate.delete(id.toString());
        System.out.println("清空缓存");
    }

    @Override
    public int getSize() {
        StringRedisTemplate stringRedisTemplate = (StringRedisTemplate) ApplicationContextUtil.getBeanByClass(StringRedisTemplate.class);
        Long size = stringRedisTemplate.opsForHash().size(id.toString());
        return size.intValue();
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return null;
    }
}
