package cn.eskyzdt.modules.threadAfter0503.c_020;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁
 * 像synchronized就是可重入锁,这里不再说了
 * 只说ReentrantLock
 *
 * reentrantlock可以替代synchronized
 */
public class T {
    ReentrantLock lock = new ReentrantLock();

    void m1() {
        lock.lock();
        System.out.println("asdfds");
        System.out.println("asdfds");
        System.out.println("asdfds");
        System.out.println("asdfds");
        System.out.println("asdfds");
        System.out.println("asdfds");
        System.out.println("asdfds");

        // 这里最好用try catch finally ,
        // 在finally中写unlock
        lock.unlock();
    }

    public static void main(String[] args) {
        T t = new T();
        Thread thread = new Thread(t::m1, "thread-01");
        thread.start();

    }

}
