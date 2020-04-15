package cn.eskyzdt.modules.designmodule.prototypepattern.entitysecond;

/**
 *  Prototype（抽象原型类）：它是声明克隆方法的接口，是所有具体原型类的公共父类
 *  这里是抽象类,也可以是接口 例: ProtoInterface
 */
public abstract class AbstractClasss implements Cloneable{

    @Override
    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

}
