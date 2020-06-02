package cn.eskyzdt.modules.designmodule.decoratorpattern;

public class TargetImpl implements TargetInterface {

    @Override
    public void run() {
        System.out.println("业务逻辑");
    }
}
