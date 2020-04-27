package cn.eskyzdt.modules.designmodule.flyweightpattern;

import java.util.HashMap;
import java.util.Map;

public class FlyweightFactory {

    private static Map<String, Object> pool = new HashMap<>();

    public static Flyweight getFlyweight(String param) {
        if (pool.containsKey(param)) {
            System.out.println("已有对象{},直接取出" + param);
            return (Flyweight)pool.get(param);
        } else {
            System.out.println("没有对象,创建对象" + param);
            ConcreteFlyweight concreteFlyweight = new ConcreteFlyweight("相同的一段文字内容");
            pool.put(param, concreteFlyweight);
            return concreteFlyweight;
        }

    }


}
