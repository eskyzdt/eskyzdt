package cn.eskyzdt.modules.threadAfter0503.c_012;

import cn.eskyzdt.modules.designmodule.singletonpattern.SingleTon;

import java.util.concurrent.TimeUnit;

public class T {


    /**
     * volatile的作用
     *
     * 禁止指令重排序
     * 以前的cpu是一条条执行, 现在是并发的,流水线执行.
     * DCL单例
     * Double Check Lock
     * Load fence\ store fence 读屏障和写屏障 (cpu原语) 保证先读后写
     *
     *
     *
     *
     * 保证线程可见性(每次写操作都会被看到)
     * 实际上是靠MESI(cpu的缓存一致性协议)来保证可见性的.比如在同步过程中又发生了改变,
     * 这里就只能靠硬件来作限制.
     *
     *
     *
     *
     */
    /**
     * 这里如果不加volatile
     * 那么main线程中对flag修改后,在run中不一定能看到
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
