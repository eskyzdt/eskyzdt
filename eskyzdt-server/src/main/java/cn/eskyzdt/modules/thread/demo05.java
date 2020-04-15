package cn.eskyzdt.modules.thread;

public class demo05 implements Runnable {

    private int count = 10;


    @Override
    public void run() {
        count--;
        System.out.println(Thread.currentThread().getId() + Thread.currentThread().getName() + "当前的count：" + count);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }

    public static void main(String[] args) {
        demo05 demo05 = new demo05();
        for (int i = 0; i < 1000; i++) {
            new Thread(demo05::run, "ddsfsdf").start();
        }
    }
}
