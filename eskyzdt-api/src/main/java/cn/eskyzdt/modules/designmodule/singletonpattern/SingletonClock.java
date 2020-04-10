package cn.eskyzdt.modules.designmodule.singletonpattern;

public class SingletonClock {

    private SingletonClock singletonClock;

    private SingletonClock() {

    }

    public SingletonClock getInstance() {
        if (singletonClock == null) {
            synchronized (SingletonClock.class) {
                singletonClock = new SingletonClock();
            }
        }
        return singletonClock;
    }

}
