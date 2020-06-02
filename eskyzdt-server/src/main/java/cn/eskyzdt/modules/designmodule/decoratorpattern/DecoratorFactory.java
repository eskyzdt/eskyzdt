package cn.eskyzdt.modules.designmodule.decoratorpattern;

public class DecoratorFactory {

    public static void doSth(String param){
        if (param == null) {
            new Decorator().run();
        }
    };

    public static void main(String[] args) {
        DecoratorFactory.doSth(null);
    }
}
