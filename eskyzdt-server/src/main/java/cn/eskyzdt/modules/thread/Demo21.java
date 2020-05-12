package cn.eskyzdt.modules.thread;

import java.util.concurrent.locks.ReentrantLock;

public class Demo21 {

    private static  int count = 0;

    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {


        Thread threadAdd = new Thread(() -> {
            lock.lock();
            try {

                for (int i = 0; i<10; i++) {
                    count++;
                    System.out.println(count);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });
        Thread threadDiv = new Thread(() -> {
            lock.lock();
            try {
                for (int i = 0; i<10; i++) {
                    count--;
                    System.out.println(count);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });
        threadAdd.start();
        threadDiv.start();







    }


}
