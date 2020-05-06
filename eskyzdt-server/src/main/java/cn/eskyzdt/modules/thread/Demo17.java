package cn.eskyzdt.modules.thread;

import java.util.concurrent.TimeUnit;


public class Demo17 {

    Object o = new Object();

    void m1() {
        synchronized (o) {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            }
        }
    }

    public static void main(String[] args) {
        Demo17 t = new Demo17();
        new Thread(() -> t.m1(), "T1").start();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /**
         * 这里如果把用作锁的o对象改变了,那么会导致锁失效,t2获得执行机会
         * 证明了锁的是堆内存中的对象而不是栈内存中的.
         */
        t.o = new Object();
        new Thread(() -> t.m1(), "t2").start();


    }
}
