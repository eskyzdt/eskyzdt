package cn.eskyzdt.modules.thread;

/**
 * 双冒号的使用
 * static方法的引用 ContainingClass::staticMethodName
 * 特定对象的方法的引用 containingObject::instanceMethodName
 * 特定类型的方法的引用 ContainingType::methodName
 * 构造器的引用  	ClassName::new
 *
 *
 *
 */
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
