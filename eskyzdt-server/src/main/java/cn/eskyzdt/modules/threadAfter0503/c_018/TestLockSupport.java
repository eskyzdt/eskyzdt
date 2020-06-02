package cn.eskyzdt.modules.threadAfter0503.c_018;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * 除了locksupport之外,其他锁都是基于aqs实现的
 *
 * 通过locksupport可以把指定的线程给叫醒
 */
public class TestLockSupport {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (i == 5) {
                    LockSupport.park();
                    LockSupport.park();
                }
            }
        });
        thread.start();
        // 如果在这里写LockSupport.unpark(thread);那么线程中的park()就不生效了
        // 会比较灵活
        // LockSupport.unpark(thread);
        TimeUnit.SECONDS.sleep(10);
        System.out.println("after 10 seconds");
        LockSupport.unpark(thread);
    }



}
