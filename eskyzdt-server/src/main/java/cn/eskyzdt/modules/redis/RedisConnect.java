package cn.eskyzdt.modules.redis;

import redis.clients.jedis.Jedis;

/**
 *
 *
 * 用redistemplate比较好
 *      比如
 *        String vin = "LFWSRXSJ1K1F11024";
 *         String vin2 = "LFWSRXSJ1K1F11024";
 *         redisTemplate.opsForHash().put(vin,vin,vin2);
 *         Object o =  redisTemplate.opsForHash().get(vin, vin);
 *        boolean qqq =  redisTemplate.expire(vin, 100, TimeUnit.SECONDS);
 *
 *          除了opsForHash()还有别的类型
 */
public class RedisConnect {

    public  void ddd() {
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


    public static void main(String[] args) {
        Jedis jedis = new Jedis("193.168.1.221",6379);
        // p密码不对会报redis.clients.jedis.exceptions.JedisDataException: ERR invalid passwordredis.clients.jedis.exceptions.JedisDataException: ERR invalid password
        String s = jedis.get("2eee");
        jedis.close();
    }

}
