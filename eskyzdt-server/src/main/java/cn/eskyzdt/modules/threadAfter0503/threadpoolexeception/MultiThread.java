package cn.eskyzdt.modules.threadAfter0503.threadpoolexeception;

import com.alibaba.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

public class MultiThread {

    public static void main(String[] args) {
        ThreadFactory build = new ThreadFactoryBuilder().build();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 300, 20, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(30), build,
                new ThreadPoolExecutor.AbortPolicy()
        );


        // 用execute会抛出异常
            executor.execute(() -> {
                System.out.println("execute start");
                    runa();
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("execute stop");
            });

            // 用submit不会抛出异常信息
        Future<?> submit = executor.submit(() -> {

            System.out.println("submit start");
            runa();
            System.out.println("submit stop");
        });
    }

    private static void runa() {
        System.out.println("1");
       // int i = 1/0;
    }





}
