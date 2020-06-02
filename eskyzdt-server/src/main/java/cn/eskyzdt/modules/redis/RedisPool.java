package cn.eskyzdt.modules.redis;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

public class RedisPool {

    private static Map<String, Object> pool = new HashMap<>();

    public static Jedis getConnector(String param) {
        if (pool.containsKey(param)) {
            return (Jedis) pool.get(param);
        } else {
            Jedis jedis = new Jedis("49.235.24.173",6380);
            jedis.auth("eskyzdt63796379");
            pool.put(param, jedis);
            return jedis;
        }
    }

    public static Jedis getConnector() {
        if (!pool.containsKey("")) {
            Jedis jedis = new Jedis("49.235.24.173",6380);
            jedis.auth("eskyzdt63796379");
            pool.put("", jedis);
        }
        return (Jedis) pool.get("");
    }

    public static void main(String[] args) throws Exception {
        Callable functionalTest = RedisPool::getConnector;
        Jedis call = (Jedis) functionalTest.call();
        String aaa = call.get("aaa");
        System.out.println(aaa);
        call.close();
    }

}
