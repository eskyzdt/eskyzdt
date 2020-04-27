package cn.eskyzdt.modules.designmodule.flyweightpattern;

public class Client {

    public static void main(String[] args) {
        int external = 1;

        Flyweight flyweight1 = FlyweightFactory.getFlyweight(String.valueOf(external));
        Flyweight flyweight2 = FlyweightFactory.getFlyweight(String.valueOf(external +1));
        Flyweight flyweight3 = FlyweightFactory.getFlyweight(String.valueOf(external +1));

        flyweight1.work("sdgfsdf");
        flyweight2.work("ncbvncvcvbcvcvbc");
        flyweight3.work("xvcxcxcxcv");
    }
}
