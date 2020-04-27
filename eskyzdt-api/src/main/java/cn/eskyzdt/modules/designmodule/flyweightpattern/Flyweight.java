package cn.eskyzdt.modules.designmodule.flyweightpattern;

/**
 * 享元模式
 *
 *
 * 这里用抽象类而不是用接口
 * 因为接口没有构造方法
 * 而且接口的字段名只能为public final static
 */
public abstract class Flyweight {

    private String internalStatus;

    /**
     * 该抽象方法的构造类
     * 当该抽象方法建立了构造类,那么他的子类一定也要有构造类
     *
     * 虽然抽象类不能被实例化，但可以有构造函数。由于抽象类的构造函数在实例化派生类之前发生，所以，可以在这个阶段初始化抽象类字段或执行其它与子类相关的代码。
     *
     * @param internalStatus
     */
    protected Flyweight(String internalStatus) {
        this.internalStatus = internalStatus;
    }

    /**
     *   一个接收外部参数的方法
      */
    public abstract void work(String externalStatus);

    public String getInternalStatus() {
        return internalStatus;
    }

    public void setInternalStatus(String internalStatus) {
        this.internalStatus = internalStatus;
    }

}
