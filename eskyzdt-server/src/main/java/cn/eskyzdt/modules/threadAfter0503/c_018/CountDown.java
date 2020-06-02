package cn.eskyzdt.modules.threadAfter0503.c_018;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDown {

    private static final CountDownLatch lock = new CountDownLatch(10);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                lock.countDown();
                System.out.println(Thread.currentThread().getName());
                try {
                    TimeUnit.SECONDS.sleep(10);
                    lock.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "lock锁已开");
            }, "thread" + i).start();

        }


    }

}
