package cn.eskyzdt.modules.javaeight;

import cn.hutool.core.map.MapUtil;

import java.util.HashMap;

public class MapTest {


    public static class TheOneEntity {

        private String var;

        public String getVar() {
            return var;
        }

        public TheOneEntity setVar(String var) {
            this.var = var;
            return this;
        }
    }


    public static void main(String[] args) {
        HashMap<String, TheOneEntity> map = new HashMap<>();
        MapUtil.getStr(map, "code");
        TheOneEntity oneEntity = new TheOneEntity();
        oneEntity.setVar("old one");

        map.put("one", oneEntity);

        TheOneEntity o = map.computeIfAbsent("one1", k -> new TheOneEntity().setVar("new one"));
        map.forEach((k,v)-> {
            System.out.println(k + " " + v + ";");
        });

    }


}
