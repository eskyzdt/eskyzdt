package cn.eskyzdt.modules.designmodule.factorymethod;

/**
 * 只有一个make方法,就是工厂模式
 *
 * 增加了一个makeComputer,就是抽象工厂模式
 *
 */
public interface Factory {

    Product make();

    Computer makeComputer();
}
