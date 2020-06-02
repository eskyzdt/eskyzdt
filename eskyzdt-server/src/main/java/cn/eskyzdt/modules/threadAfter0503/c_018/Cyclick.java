package cn.eskyzdt.modules.threadAfter0503.c_018;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class Cyclick {

    private static CyclicBarrier lock = new CyclicBarrier(20, ()->{
        System.out.println("lock is tripped");
    });

    public static CyclicBarrier getLock() {
        return lock;
    }

    public static void setLock(CyclicBarrier lock) {
        Cyclick.lock = lock;
    }

    public static void main(String[] args) {
        CyclicBarrier lock = Cyclick.getLock();
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                try {
                    TimeUnit.SECONDS.sleep(1);
                    lock.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                } finally {
                }
            },"Thread" + i).start();
        }

    }


}
