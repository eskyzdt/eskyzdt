package cn.eskyzdt.modules.threadAfter0503.c_018;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读锁是共享锁,写锁是排他锁(互斥锁)
 * StampedLock是ReadWriteLock的升级版
 */
public class ReadWriteLock {

    private static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    private static final ReentrantReadWriteLock.ReadLock readLock = lock.readLock();

    private static final ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                readLock.lock();
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("readLock");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    readLock.unlock();
                }
            }).start();
        }

        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                writeLock.lock();
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("writelock");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    writeLock.unlock();
                }
            }).start();

        }


    }

}
