package cn.eskyzdt.modules.map;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class MapMessage {

    public static void main(String[] args) {
        createMap();

        createConcurrentHashMap();
    }

    /**
     * 用getOrDefault可以在值为null的时候获得一个默认值
     */
    private void getOrDefault() {
//        HashMap<Long, CountDownScVo> map = new HashMap<>();
//        CountDownScVo vo = map.getOrDefault(ownerNo, new CountDownScVo(ownerNo, tem.getOwnName(), tem.getDepName()));

    }


    /**
     * hashmap是允许null键和null值的
     */
    private static void createMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("","");
        map.put(null, "");
        map.forEach((k,v)->{
            System.out.println("key: " + k + "value: " + v);
        });
        System.out.println("-------------------------------");
        map.put("",null);
        map.put(null,null);
        map.forEach((k,v)->{
            System.out.println("key: " + k + "value: " + v);
        });
    }

    /**
     * 但是concurrentMap不允许
     */
    private static void createConcurrentHashMap() {
        ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<>();
        map.put("","");
        map.put(null, "");
        map.forEach((k,v)->{
            System.out.println("key: " + k + "value: " + v);
        });
        System.out.println("-------------------------------");
        map.put("",null);
        map.put(null,null);
        map.forEach((k,v)->{
            System.out.println("key: " + k + "value: " + v);
        });
    }

}
