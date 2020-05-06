package cn.eskyzdt.modules.threadAfter0503.c_020;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 公平锁
 * 谁先等待谁先拿到这个锁,不会让后来的先拿到锁
 * <p>
 * 比如有一个锁,那么想获取这个锁的线程都在一个队列里,那么新来一个线程,去不去看这个队列就成为是否是公平锁的关键
 * 首先一个线程会检查队列中是否有别的线程,没有的话就直接执行,否则就继续等
 * <p>
 * <p>
 * 不过这个不能保证一定是一人一次拿到,比如一个线程拿到锁,然后释放了,其他线程还没来得及进队列呢
 * 这个线程又一次进队列了,导致还是这个线程拿到锁.
 * 但至少会有一些间歇性的输出,如果不用公平锁,那么会导致一大片一大片相同的输出
 */
public class FairLock {
    // 不加true线程数会乱,加true,输出的线程会基本上从小到大的,因为他们排队了.
    private static ReentrantLock lock = new ReentrantLock(true);

    public static void main(String[] args) {
        FairLock tFairlock = new FairLock();
        List<Thread> list = new ArrayList<>();
        // 开10个线程,a和b各5个
        for (int i = 0; i < 5; i++) {
            list.add(new Thread(() -> tFairlock.run(), "a" + i));
            list.add(new Thread(tFairlock::run2, "b" + i));
        }
        list.forEach(o -> o.start());
        list.forEach(o -> {
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    public void run() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName());
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void run2() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName());
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
