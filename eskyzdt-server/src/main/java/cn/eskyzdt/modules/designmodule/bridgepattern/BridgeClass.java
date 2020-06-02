package cn.eskyzdt.modules.designmodule.bridgepattern;

/**
 * 桥接模式的重点在于一个是抽象类一个是接口类
 *
 * 抽象类是使用时要new出来的,用抽象类的原因是可以有构造方法
 *
 * 在构造方法中把其他的接口传入
 *
 *
 */
public class BridgeClass  {

    public static void main(String[] args) {
        Linux linux = new Linux(new MP4Type());
        Windows windows = new Windows(new AVIType());
        linux.run();
        windows.run();

    }
}
