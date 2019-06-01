package com.baizhi;

import com.alibaba.fastjson.JSONArray;
import io.goeasy.GoEasy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
public class goEasyTests {

    @Test
    public void contextLoads() {
      /*  ArrayList<Integer> list = new ArrayList<>();
        list.add(new Random().nextInt(1000));
        list.add(new Random().nextInt(1000));
        list.add(new Random().nextInt(1000));
        list.add(new Random().nextInt(1000));
        list.add(new Random().nextInt(1000));
        list.add(new Random().nextInt(1000));
        JSONArray jsonArray = new JSONArray();
        jsonArray.addAll(list);
        String jsonString = jsonArray.toJSONString();
        GoEasy goEasy = new GoEasy( "http://rest-hangzhou.goeasy.io", "BC-b121a256bfeb4d0e874c71b5a744d092");
        goEasy.publish("test_channel", "jsonString");
    }*/
    }
}