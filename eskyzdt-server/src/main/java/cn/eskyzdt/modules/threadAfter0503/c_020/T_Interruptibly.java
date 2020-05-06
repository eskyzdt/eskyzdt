package cn.eskyzdt.modules.threadAfter0503.c_020;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * synchronized如果wait了
 * 那么必须要其他的线程notify才能醒过来
 * 而Reentrantlock可以用lock.lockInterruptibly(),允许其他线程打断
 *
 * 注意被打断时会catch (InterruptedException e)
 *
 */
public class T_Interruptibly {

    private ReentrantLock lock = new ReentrantLock();

    public void m1() {
        try {
            lock.lockInterruptibly(); // 可以对interrupt()作出响应,即可被打断的加锁
            System.out.println("m1 start");
            TimeUnit.SECONDS.sleep(50);
            System.out.println("m2 end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void m2() {
        boolean b = false;
        try {
            System.out.println("m2 try to get lock in 5 seconds");
            b = lock.tryLock(5, TimeUnit.SECONDS);
            System.out.println("if you see this sentence in 2 secondes, thread was interrupted");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (b) {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        T_Interruptibly t = new T_Interruptibly();
        Thread m1 = new Thread(t::m1, "thread");
        Thread m2 = new Thread(t::m2, "thread-2");
        m1.start();
        m2.start();
        try {
            System.out.println("main thread sleep 2 seconds");
            TimeUnit.SECONDS.sleep(2);
            m1.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
