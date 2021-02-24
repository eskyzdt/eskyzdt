package cn.eskyzdt.modules.thread;

public class JoinTest {

    public static class JoinDemo extends Thread{
        // 当前线程
        Thread curThread;

        public JoinDemo(Thread curThread){
            this.curThread=curThread;
        }
        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + "开始睡觉");
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + "睡醒了");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    // 主线程执行->

    public static void main(String[] args) throws InterruptedException {
        // 第一个线程是主线程
        Thread thread = Thread.currentThread();
        for(int i=0;i<10;i++){
            System.out.println("主线程第" + i + "次开始运行");
            // 每个循环开一个线程
            JoinDemo joinDemo = new JoinDemo(thread);
            // 上一个线程执行
            joinDemo.start();
            // join的意思就是直到当前线程运行结束了才继续下一步
            // 这里就是joinDemo执行结束了才回主线程运行
            joinDemo.join();
        }
    }
}
