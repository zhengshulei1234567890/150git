package com.baizhi.test;

import com.baizhi.App;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.SpringBootDependencyInjectionTestExecutionListener;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.naming.Name;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class TestRedis {
    @Autowired
    //RedisTemplate redisTemplate;
    StringRedisTemplate stringRedisTemplate;
    @Test
    public void test1() {
        //redisTemplate.opsForValue().set("name", "zhangsan");
        //Object name = redisTemplate.opsForValue().get("name");
        stringRedisTemplate.opsForValue().set("name" ,"zhangsan");
        List<String> strings = Arrays.asList("name");
        // System.out.println(name);
        stringRedisTemplate.delete(strings);

    }

}
