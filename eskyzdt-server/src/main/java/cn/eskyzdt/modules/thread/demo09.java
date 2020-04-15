package cn.eskyzdt.modules.thread;

/**
 * 可重入锁
 */
public class demo09 {

    // t1中调用t2，但是t1已经拿到锁了，t2也需要锁，此时不会发生死锁，因为都是在自己这个线程中，只是锁会拿
//     两次，锁的值加一（小细节不用管）
    // 这就叫可重入锁
    synchronized void t1() {
        System.out.println("aaaaa");
        t2();
    }

    synchronized void t2() {
        System.out.println("bbb");
        t1();
    }


}
