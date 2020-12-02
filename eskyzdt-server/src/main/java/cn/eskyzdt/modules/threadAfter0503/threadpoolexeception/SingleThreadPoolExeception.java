package cn.eskyzdt.modules.threadAfter0503.threadpoolexeception;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadPoolExeception {

    public static void main(String[] args) {
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        singleThreadExecutor.execute(()->{
            runa();
        });
    }

    private static void runa() {
        System.out.println("1");
        int i = 1/0;
    }
}
