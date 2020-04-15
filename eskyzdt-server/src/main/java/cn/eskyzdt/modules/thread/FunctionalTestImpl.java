package cn.eskyzdt.modules.thread;

public class FunctionalTestImpl {

    public static void main(String[] args) {

        FunctionalTest t1 = () -> {
            System.out.println("lalala");
        };

        t1.Th1();
    }

}
