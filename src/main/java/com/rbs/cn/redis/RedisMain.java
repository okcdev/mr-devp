package com.rbs.cn.redis;

import redis.clients.jedis.Jedis;

/**
 * Created by fengtao.xue on 2018/2/6.
 */
public class RedisMain {


    public static void dealRedis(){
        Jedis jedis = new Jedis("localhost");
        jedis.set("foo", "bar");
        String value = jedis.get("foo");
    }
}
