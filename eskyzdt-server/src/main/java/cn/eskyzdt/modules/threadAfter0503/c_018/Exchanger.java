package cn.eskyzdt.modules.threadAfter0503.c_018;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 交换器
 *
 * 交换只能两两交换
 * exchange的时候exchanger会阻塞
 * 如果只有一个exchange()执行,那么会阻塞,exchange和wait比较像
 *
 *
 */
public class Exchanger {

    static java.util.concurrent.Exchanger<String> exchanger = new java.util.concurrent.Exchanger<>();

    public static void main(String[] args) {
        new Thread(()->{
            String t1 = "t1";
            String result = null;
            String exchange = null;
            try {
                // 交换后的结果
                exchange = exchanger.exchange(t1, 10, TimeUnit.SECONDS);
                result = exchanger.exchange(t1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            } finally {
                System.out.println(Thread.currentThread().getName() + result + "11111111111");
                System.out.println(exchange + "+=================");
            }
        },"t1").start();
        new Thread(()->{
            String t2 = "t2";
            String result = null;
            try {
                // 交换后的结果
                result = exchanger.exchange(t2);
                result = exchanger.exchange(t2,10, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            } finally {
                System.out.println(Thread.currentThread().getName() + result + "22222222222");
            }
        }, "t2").start();
    }


}
