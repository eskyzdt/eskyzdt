package cn.eskyzdt.modules.designmodule.prototypepattern.entityfirst;

import cn.eskyzdt.modules.designmodule.factorymethod.ProductA;

/**
 *  Prototype（抽象原型类）：它是声明克隆方法的接口，是所有具体原型类的公共父类
 *  这里是接口，但是也可以是抽象类。 例:AbstractClass
 */
public interface ProtoInterface extends Cloneable {

    String name = "daafsdaf";

    public final static ProductA productA = new ProductA();

    public abstract ProtoInterface clone();



}
