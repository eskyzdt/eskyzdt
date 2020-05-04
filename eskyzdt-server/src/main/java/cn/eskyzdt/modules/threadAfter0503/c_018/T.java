package cn.eskyzdt.modules.threadAfter0503.c_018;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class T {

    /**
     * 无锁优化CAS 自旋
     * CAS
     * Compare and Set/Swap
     * cas(V(要改的值), Expected(期望值), NewValue(要被改成的值))
     * 如果当前的值和期望值一样,就把newvalue给新的值
     * 因为如果一样,我就默认没有别的线程进来对值进行过改动,所以是乐观锁
     *
     * if V == E
     *  V = New
     *  otherwise try again or fail
     *  -- CPU原语支持
     *
     *  CAS会产生ABA问题:
     *  expected变先改成newvalue,然后又被改成expected,怎么办
     *  比如一开始是1,然后被改为2, 又被改为1, cas无法判断,但是值实际上做了改变.
     *  解决办法 如果是int这种基础数据类型,无所谓,因为最后反正都是1
     *  如果是引用类型,aba会产生问题
     *  对于引用类型,可以加上版本号,或者java有个类  AtomicStampedReference,用该类解决ABA问题,实际上是加个时间戳.
     *
     *
     *
     *
     *
     *
     *
     *
     *
     */
    AtomicInteger count = new AtomicInteger(0);

    /*synchronized*/ void m() {
        for (int i = 0; i < 10000; i++) {
            count.incrementAndGet(); // 相当于count++;
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        T t = new T();
        ArrayList<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(t::m, "thread" + i));
        }

        threads.forEach(Thread::start);

        threads.forEach((o)->{
            try {
                o.join();
            } catch (InterruptedException e) {
            }

        });


    }


}
