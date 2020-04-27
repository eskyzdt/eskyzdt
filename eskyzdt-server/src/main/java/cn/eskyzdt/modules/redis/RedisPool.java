package cn.eskyzdt.modules.redis;

import cn.eskyzdt.modules.thread.FunctionalTest;
import com.google.common.base.Function;
import com.google.common.base.Supplier;
import com.rabbitmq.client.UnblockedCallback;
import redis.clients.jedis.Jedis;

import java.util.*;
import java.util.function.Consumer;

public class RedisPool {

    private static Map<String, Object> pool = new HashMap<>();

/*
    public static Jedis getConnector (String param) {
        if (pool.containsKey(param)) {
            return (Jedis) pool.get(param);
        } else {
            Jedis jedis = new Jedis();
            pool.put(param, jedis);
            return jedis;
        }
    }
*/
    private void getStr() {
        System.out.println("sdfsdfsdfsdf");
    }


    public static void main(String[ ] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add(1,"1");
        strings.add(2,"1");

        RedisPool redisPool = new RedisPool();
        FunctionalTest getStr = redisPool::getStr;
        getStr.Th1();

        // strings.forEach(System.out::println);



    }

}
