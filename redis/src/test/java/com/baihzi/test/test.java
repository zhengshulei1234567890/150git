package com.baihzi.test;

import org.junit.Test;
import redis.clients.jedis.Jedis;

public class test {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.234.30", 7000);
        //jedis.lindex()
        //jedis.select(0);
       //获取某一个指定索引位置的元素
        //jedis.lindex("name",1);
        //lrem 删除重复元素
        jedis.lrem("name",2,"xiaohua");
        jedis.close();
    }
}