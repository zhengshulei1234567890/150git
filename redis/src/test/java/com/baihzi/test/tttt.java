package com.baihzi.test;

import redis.clients.jedis.Jedis;

import java.awt.image.Kernel;
import java.util.List;
import java.util.Set;

public class tttt {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.234.30",7000);
        jedis.select(0);
        System.out.println("连接成功");
        //jedis.set("rst","llll");
        //System.out.println("redis 存储的字符串"+jedis.get("rst"));
        //String type = jedis.type("name");
        //System.out.println(type);
       /* Set<String> keys = jedis.keys("*");
        for (String key : keys) {
            System.out.println(key);
        }*/
       // String key = jedis.randomKey();
        //System.out.println(key);


        //反回key 的失效时间
       // Long ttl = jedis.ttl("topls");
        //返回-1 永不失效   返回-2 key不存在 返回整数 剩余时间
        //System.out.println(ttl);

        //移动某个key到指定的库
        //jedis.move("age" ,1);

        //测试与字符串相关API
        //设置一个key/value
        //jedis.set("salary","8999");
        //get 根据key获得对应的value
        //String name = jedis.get("name");
        //System.out.println(name);
        //一次设置多个key value
        //String mset = jedis.mset("name", "xifu", "birthday", "2019-5-11");
        //mget一次获得多个key的value
       // List<String> mget = jedis.mget("name", "birthday");
       // for (String s : mget) {
        //    System.out.println(s);
      //  }
        //jedis.append("name","123456789");
       // String name = jedis.getrange("name", 0, -1);
       // System.out.println(name);
        //获取之前的value 并设置新的value
        //String beforename = jedis.getSet("name", "niangzi");
        //System.out.println(beforename);
       // String name = jedis.get("name");
        //System.out.println(name);
        //strlen 	获得对应key存储value的长度
        //Long length = jedis.strlen("name");
       // System.out.println(length);

        //setex 	设置一个key存活的有效期（秒）
        //jedis.setex("id",20,"1");
        //setnx 	存在不做任何操作,不存在添加
        //jedis.setnx("newName","lisi wangwu zhaosan");
        //msetnx 	可以同时设置多个key,只有有一个存在都不保存
        //jedis.msetnx("age","lisi","wangwu","122");
        //decr (不存在则创建)	进行数值类型的-1操作
        //jedis.decr("classname");
        //Decrby  (不存在则创建)	根据提供的数据进行减法操作
       // jedis.decrBy("classage",2);
        //jedis.incrBy("classage",4);
        //jedis.incrByFloat("classage",2.3333333);
        //jedis.lpush("name","xiaoming","xiaosan","ll");
        //lpushx 	同lpush,但是必须要保证这个key存在
       // jedis.lpushx("name","xiaolang");
        //rpush 	将某个值加入到一个key列表末尾
        //jedis.rpush("names","kk");
        //rpushx 	同rpush,但是必须要保证这个key存在
        //jedis.rpushx("names","mima");
        //lpop 	返回和移除列表的第一个元素
        //jedis.lpop("name");
        //lrange 	获取某一个下标区间内的元素
        /*List<String> name = jedis.lrange("name", 0, 3);
        for (String s : name) {
            System.out.println(s);
        }*/
        //llen 	获取列表元素个数
        //Long count = jedis.llen("names");
        //System.out.println(count);
        //lset 	设置某一个指定索引的值(索引必须存在)
        //String lset = jedis.lset("name", 2, "xiaos");
        //lindex 	获取某一个指定索引位置的元素
       // String name = jedis.lindex("name", 2);
       // System.out.println(name);
        //lrem 	删除重复元素
        jedis.lrem("name", 2, "xiaos");



        jedis.close();


    }
}
