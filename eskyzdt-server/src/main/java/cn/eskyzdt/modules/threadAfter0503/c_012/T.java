package cn.eskyzdt.modules.threadAfter0503.c_012;

import java.util.concurrent.TimeUnit;

public class T {


    /**
     * volatile的作用
     *
     * 1. 禁止指令重排序
     * 1.1以前的cpu是一条条执行,现在是并发的,流水线执行.
     * (当前cpu架构可能是运行一个指令,未结束时就执行下一条指令)
     * (比如你希望程序按照123来执行,而cpu把指令重排序后把程序改为132,用volatile则禁止这个指令重排序)
     * 1.2DCL单例
     * Double Check Lock ****** 双重检查锁,就是我写单例时候写的双重判断
     * Double Check Lock可以保证线程安全性
     *     既然dcl已经可以保证线程安全性,那么
     *      *      在dcl中是否需要用volatile来修饰待被创建的变量呢?
     *      *          答案是要的
     *      因为需要volatile来禁止指令重排序
     *
     * 1.3Load fence\ store fence 读屏障和写屏障 (cpu原语) 保证先读后写
     *
     *
     * 2.保证线程可见性(每次写操作都会被看到)
     * 实际上是靠MESI(cpu的缓存一致性协议)来保证可见性的.
     * 比如实际上在同步过程中有可能又发生了改变,
     * 所以实际上是靠硬件来作限制.
     * 靠mesi来保证可见性
     *
     *
     */
    /**
     * 这里如果不加volatile
     * 那么main线程中对flag修改后,在run中不一定能看到
     *
     *
     * 开发的时候直接用饿汉模式,在字段上就直接new对象,这样就是由spring来创建对象
     * 不用自己去new
     * java虚拟机只会去创建一个对象,就不会出问题
     *
     */
    private volatile boolean flag = true;

    // 这里还有知识点参见cn.eskyzdt.modules.designmodule.singletonpattern.SingleTon
    //private SingleTon s;



    public void run (){

        int i = 0 ;
        while (flag) {
            /**
             * ....
             */

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(++i);
        }
        System.out.println("already done");
    }


    public static void main(String[] args) {
        T t = new T();
        Thread t1 = new Thread(t::run, "t1");
        t1.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.flag = false;


    }

}
