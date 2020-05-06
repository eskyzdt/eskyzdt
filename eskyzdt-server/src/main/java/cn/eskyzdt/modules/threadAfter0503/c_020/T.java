package cn.eskyzdt.modules.threadAfter0503.c_020;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁 since java1.5
 * 像synchronized就是可重入锁,这里不再说了
 * 只说ReentrantLock
 * <p>
 *  重要:
 *  reentrantlock可以替代synchronized
 *  reentrantlock可以替代synchronized
 *  reentrantlock可以替代synchronized
 *
 *  reentrantlock只是比synchronized好用点而已
 *  但是re可以做到拿到锁就处理,拿不到就走拿不到的逻辑
 *  这是比syn厉害的地方.syn是做不到这一点的
 */
public class T {
    ReentrantLock lock = new ReentrantLock();

    void m1() {
        lock.lock();
        try {
            System.out.println("m1 is running");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 在finally中写unlock
            lock.unlock();
            // 保证锁安全释放
        }
    }

    void m2() {
        boolean flag = false;
        try {
            for (int i = 0; i < 5; i++) {
                // 注意这里要是能拿到,那么是不会等2s的
                flag = lock.tryLock(2, TimeUnit.SECONDS);
                System.out.println("m2 try to get lock: " + flag);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (flag) {
                lock.unlock();
            }
        }
    }


    public static void main(String[] args) {
        T t = new T();
        Thread thread = new Thread(t::m1, "thread-01");
        thread.start();

        Thread thread1 = new Thread(t::m2, "thread-02");
        thread1.start();

    }

}
