package cn.eskyzdt.modules.designmodule.flyweightpattern;

public class UnsharedConcreteFlyweight extends Flyweight {


    /**
     * 构造类
     *
     * @param internalStatus
     */
    protected UnsharedConcreteFlyweight(String internalStatus) {
        super(internalStatus);
    }

    @Override
    public void work(String externalStatus) {
        System.out.println();
    }
}
