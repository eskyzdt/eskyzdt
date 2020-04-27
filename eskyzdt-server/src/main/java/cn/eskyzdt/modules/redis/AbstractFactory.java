package cn.eskyzdt.modules.redis;

import redis.clients.jedis.Jedis;

public abstract class AbstractFactory {

    abstract Jedis getSth();
}
