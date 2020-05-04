package cn.eskyzdt.modules.designmodule.singletonpattern;

public class SingleTon {

    /**
     * 那这里要不要加volatile呢,答案是要加
     *
     * 因为指令重排序
     *
     * 不加的话在超高并发的情况下可能出现问题
     * 因为 类的初始化分为三个部分,第一步 加载类 第二步 初始化字段,给一个默认值,例如如果是int的话默认值是0
     * 第三步,执行代码
     * 如果不加volatile,那么有可能在初始化值为0的时候就已经被读取了.
     *
     *
     *
     * vilatile 只能保证可见性,不能保证原子性,所以如果用了volatiole,需要synchronized的时候也还是要用的
     */
    private static SingleTon singleTon;

    /**
     * 注意这里要synchronized
     *
     * @return
     */
    public static SingleTon getInstance() {
        // 注意这里的位置,不能加在new里
        synchronized (SingleTon.class) {
            if (singleTon == null) {
                singleTon = new SingleTon();
            }
        }
        return singleTon;
    }

    // 优化,这里用双重判断
    // 原因是一上来不先加锁,效率会高
    public static SingleTon getInstance2() {
        if (singleTon == null) {
            // 双重
            synchronized (SingleTon.class) {
                if (singleTon == null) {
                    singleTon = new SingleTon();
                }
            }
        }
        return singleTon;
    }

    public void run() {
        System.out.println("业务逻辑");
        System.out.println(singleTon);
    }

    public static void main(String[] args) {
        SingleTon instance = SingleTon.getInstance();
        SingleTon instance2 = SingleTon.getInstance();

        instance.run();
        instance2.run();


    }


}
