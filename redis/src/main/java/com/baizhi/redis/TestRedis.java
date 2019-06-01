package com.baizhi.redis;

import redis.clients.jedis.Jedis;

public class TestRedis {
    private Jedis jedis;

      public void setup() {
                //连接redis服务器，192.168.0.100:6379
          Jedis jedis = new Jedis("192.168.234.30", 7000);
          //权限认证
               this.jedis.select(0);
             }
}
