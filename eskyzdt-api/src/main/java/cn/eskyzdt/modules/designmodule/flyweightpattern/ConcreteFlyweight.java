package cn.eskyzdt.modules.designmodule.flyweightpattern;

public class ConcreteFlyweight extends Flyweight {

    public ConcreteFlyweight(String internalStatus) {
        super(internalStatus);
    }

    @Override
    public void work(String externalStatus) {
        System.out.println(super.getInternalStatus() + "    外部数据为:" + externalStatus);
    }
}
