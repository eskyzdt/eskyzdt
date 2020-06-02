package cn.eskyzdt.modules.threadAfter0503.part4.mianshi;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class T {

    private List<Integer> list = new ArrayList<>();

    public int getSize() {
        return list.size();
    }

    public void put(int i) {
        list.add(i);
    }


    public static void main(String[] args) {
        T t = new T();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchronized (t) {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(i);
                    t.put(i);
                    t.notifyAll();
                    try {
                        t.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(()->{
            while (true) {
                synchronized (t) {
                    if (t.getSize() == 5) {
                        System.out.println("stop thread");
                    }
                    try {
                        t.notifyAll();
                        t.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }).start();

    }
}
