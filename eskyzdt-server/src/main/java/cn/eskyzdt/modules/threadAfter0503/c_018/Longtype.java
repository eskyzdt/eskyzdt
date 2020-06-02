package cn.eskyzdt.modules.threadAfter0503.c_018;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

public class Longtype {

    static long count;

    /**
     * atomicXXX的原理就是CAS
     * 对比synchronized和atomicInterger和longadder
     * adtomic因为用的是CAS代替锁,相对来说效率要高一点,当然有时候syn高一些,不做讨论
     */
    static AtomicLong count2 = new AtomicLong();

    /**
     * longadder用了分段锁,所以在线程数量非常多的时候,速度会比较快
     * 比如longadder会把字段分为3个部分,某200个线程锁part1,另200个锁part2....最后把3个部分加起来
     * 所以线程特别多的情况下就比较快
     */
    static LongAdder count3LongAdder = new LongAdder();

    static final Longtype lock = new Longtype();

    void run() {
        synchronized (lock) {
            for (int i = 0; i < 10000; i++) {
                count++;
            }
        }
    }

    public static void main(String[] args) {
        test01();
        test02();
        test03();

    }

    public static void test01() {
        /*
            第一个long类型测试
            ========================================================
         */
        long time01start = System.currentTimeMillis();
        List<Thread> threads1 = new ArrayList<>();
        Longtype longtype = new Longtype();
        for (int i = 0; i < 100000; i++) {
            threads1.add(new Thread(longtype::run, "threadLong" + i));
        }
        threads1.forEach((o) -> {
            o.start();
        });
        threads1.forEach((o) -> {
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        long time01end = System.currentTimeMillis();
        System.out.println("total 01 time use is " + (time01end - time01start));
        System.out.println("count1 =" + count);


    }

    public static void test02() {
        /**
         * 第二个atomic类型测试
         */
        long time02start = System.currentTimeMillis();
        List<Thread> list2 = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            list2.add(new Thread(()->{
                for (int j = 0; j < 10000; j++) {
                    count2.incrementAndGet();
                }
            }));
        }
        list2.forEach((o)->{
            o.start();
        });
        list2.forEach((o)->{
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

        long time02end = System.currentTimeMillis();
        System.out.println("total 02 time use is " + (time02end -time02start));
        System.out.println("count2=" +count2);

    }

    public static void test03() {
        long time03start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            new Thread(()->{
                for (int j = 0; j < 10000; j++) {
                    count3LongAdder.add(1);
                }
            }).start();
        }
        long time03end = System.currentTimeMillis();
        System.out.println("total 03 time use is " + (time03end -time03start));
        System.out.println("count3=" +count2);
    }

}
