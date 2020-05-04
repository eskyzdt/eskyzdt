package cn.eskyzdt.modules.threadAfter0503.c_013;

import java.util.ArrayList;
import java.util.List;

public class T {

    /**
     * 锁优化
     *
     * 把锁粒度变粗或者变细
     *
     * 变细都能理解
     * 变粗是因为假如每一行代码都加一个锁
     * 那不如加个大锁
     *
     * 用对象做为锁时
     * 如果用某个对象当锁
     * 当这个对象发生了改变,那么就会出问题.
     * (锁是对象上的某几位信息,当这个对象变了之后,这个锁就不见了)
     *
     * 解决办法,把用作锁的这个对象前面加上final
     * 就不会出现锁改变的情况了
     *
     */


    private volatile int i;

    void m() {
        for (int c = 0; c < 10000; c++) {
            i++;
        }
    }

    /**
     * 10个线程每个线程加1w次,
     * 本来应该是10W,但是结果不是10W
     * 因为这里i++ 不能保证原子性.
     *
     * 加synchronized就可以保证了
     * @param args
     */
    public static void main(String[] args) {
        T t = new T();

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            // 注意这里是小写t::m
            Thread thread = new Thread(t::m, "thread-" + i);
            threads.add(thread);
        }

        threads.forEach((a) -> a.start());

        threads.forEach((o) -> {
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(t.i);


    }


}
