package cn.eskyzdt.modules.redis;

import redis.clients.jedis.Jedis;

public class RedisConnect {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("49.235.24.173",6380);
        // p密码不对会报redis.clients.jedis.exceptions.JedisDataException: ERR invalid passwordredis.clients.jedis.exceptions.JedisDataException: ERR invalid password
        jedis.auth("eskyzdt63796379");
        jedis.set("aaa","ccc");
        jedis.close();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        jedis = new Jedis("49.235.24.173",6380);
        jedis.auth("eskyzdt63796379");
        String aaa = jedis.get("aaa");
        System.out.println(aaa);
        jedis.close();



    }

}
