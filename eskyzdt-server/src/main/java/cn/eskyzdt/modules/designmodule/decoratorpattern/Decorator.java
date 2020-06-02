package cn.eskyzdt.modules.designmodule.decoratorpattern;

public class Decorator implements TargetInterface{


    @Override
    public void run() {
        TargetImpl target = new TargetImpl();
        System.out.println("装饰器模式装饰的逻辑");
        target.run();
    }
}
