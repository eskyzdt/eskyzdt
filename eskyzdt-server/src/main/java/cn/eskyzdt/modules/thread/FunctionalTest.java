package cn.eskyzdt.modules.thread;

@FunctionalInterface
public interface FunctionalTest{

    /**
     * 一个函数式接口中仅能包含一个抽象方法
     */
    public void Th1();

    public default void defaultMethod(){
        System.out.println("aaa");
    }

    public static void staticMethod(){
        System.out.println("a");
    }

}
