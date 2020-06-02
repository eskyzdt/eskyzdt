package cn.eskyzdt.modules.threadAfter0503.c_018;

/**
 * 作用: 限流
 *
 * 最多同时有多少个线程可以运行
 * 比如卖票
 */
public class Semaphore {
    /**
     * 在permits中写了数字几,那么就可以同时有多少个线程同时执行
     * 如果换成2那么下面两个会同时执行
     * 如果是1那么必须先一个执行完
     * 后一个线程才可以执行
     */
    // private static final java.util.concurrent.Semaphore s = new java.util.concurrent.Semaphore(1);
    private static final java.util.concurrent.Semaphore s = new java.util.concurrent.Semaphore(1, true);

    public static void main(String[] args) {
       new Thread(()->{
           try {
               // 获得这个锁
               s.acquire();
               System.out.println("t1 running");
               Thread.sleep(2000);
               System.out.println("t1 running");
           } catch (InterruptedException e) {
               e.printStackTrace();
           } finally {
               // 释放锁
               s.release();
           }
       },"t1").start();

        new Thread(()->{
            try {
                s.acquire();
                System.out.println("t2 running");
                Thread.sleep(2000);
                System.out.println("t2 running");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                s.release();
            }
        },"t2").start();
    }

}
