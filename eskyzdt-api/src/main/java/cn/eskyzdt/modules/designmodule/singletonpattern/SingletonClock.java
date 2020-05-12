package cn.eskyzdt.modules.designmodule.singletonpattern;

/**
 * 用这种方式实际上失去了单例的意义,因为每次都要new一个
 * 如果用static类型修饰,在使用的时候每次调用的都是一个静态方法
 * 这样可以保证每次调用的都是同一个
 */
public class SingletonClock {

    private SingletonClock singletonClock;

    private SingletonClock() {

    }

    public SingletonClock getInstance() {
        if (singletonClock == null) {
            synchronized (SingletonClock.class) {
                // 注意这里也要加判断,不然高并发有可能new两次
                if (singletonClock == null) {
                    singletonClock = new SingletonClock();
                }
            }
        }
        return singletonClock;
    }

}
