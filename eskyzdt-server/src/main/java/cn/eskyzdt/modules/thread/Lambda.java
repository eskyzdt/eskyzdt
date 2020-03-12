package cn.eskyzdt.modules.thread;

public class Lambda {

    void q1() {
        new Thread(() -> {});

    }


}

class Th1 implements Runnable {

    @Override
    public void run() {

    }
}
