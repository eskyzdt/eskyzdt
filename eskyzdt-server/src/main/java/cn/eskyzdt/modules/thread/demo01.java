package cn.eskyzdt.modules.thread;


public class demo01 {

    private int count;
    private Object o = new Object();

    public void m() {
        synchronized(this) {
            count--;
            System.out.println(Thread.currentThread().getName() + "当前执行的锁" + count);
        }
    }

    // 写在方法上的synchronized是synchronized(this)的简略写法
    public synchronized void n() {
        count++;
        System.out.println(Thread.currentThread().getId() + "当前线程" + count);
    }


}
