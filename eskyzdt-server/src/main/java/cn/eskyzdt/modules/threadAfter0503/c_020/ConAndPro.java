package cn.eskyzdt.modules.threadAfter0503.c_020;

import java.util.concurrent.TimeUnit;

/**
 * 生产者和消费者
 *
 */
public class ConAndPro {

    private String[] list = new String[30];


    int size = 0;

    // 不加synchronized,会导致多次消费,重复消费,可能会消费多了导致出问题
    public  synchronized String get() {
        String s = null;
        if (size == 0) {
            System.out.println("取完数据了!");
        } else {
            size--;
            s = list[size];
            System.out.println("取数据: 取出的数据为" + s);
        }
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return s;
    }

    public synchronized void put(String s) {
        list[size] = s;
        System.out.println("在" + size + "位放入数据" + s);
        size++;
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        ConAndPro conAndPro = new ConAndPro();
        for (int i = 0; i < 2; i++) {
            new Thread(()->{
                int j = 0;
                while (true) {
                  //  System.out.println("生产者运行");
                    conAndPro.put(String.valueOf(j++));
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "productor" + i).start();
        }


        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                int j = 0;
                while (true) {
               //     System.out.println("消费者运行");
                    String s = conAndPro.get();
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            },"consumer" + i).start();
        }


    }

}
