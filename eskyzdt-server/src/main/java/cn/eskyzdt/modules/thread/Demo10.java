package cn.eskyzdt.modules.thread;

/**
 * 子类调用父类的方法
 * 都加锁的话也是一样允许
 * 他们锁的也依然是同一个对象
 */
public class Demo10 {

    synchronized void run() {
        System.out.println("parent");
    }

    public static void main(String[] args) {
        Child demo = new Child();
        demo.run();
    }


}

/**
 * 一个java文件中可以有多个类，但是有一个类必须为public
 * public代表这个类可以被其他的类继承，也可以被引入
 * 不加public意思只能本包中能用
 */
class Child extends Demo10{

    @Override
    synchronized void run() {
        super.run();
        System.out.println("child");
    }
}
