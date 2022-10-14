package cn.eskyzdt.面试;

import java.util.Map;
import java.util.WeakHashMap;

public class one {

    // #软引用: jvm内存空间够就不会清除, 不够了就清
    // #弱引用 :只要被GC发现, 直接回收

    //THREADLocal:
    //每个DAO层都会有一个ConnThreadLocal对象, 当service层一个请求线程过来时,会访问自己的ConnThreadLocal对象(ConnThreadLocal = new ThreadLocal<Connection>()), 从里面取Connection对象,如果有就直接使用,没有就新建一个
    //
    //ThreadLocal.set 该方法在set的时候,实际上是往每个线程中的ThreadLocalMap中放key和value
    //每个线程中都有一个ThreadLocal 的 map
    //
    //在线程中使用ThreadLocal.set(T)时, 实际上是当前的线程  把当前ThreadLocal为key, T为value, 放到线程中的ThreadLocalMap中去
    //而这个set方法里面, 会对key进行处理, 把key和value变为Entry<K,V>, 这里的Entry继承了weakReference, 所以此时, ThreadLocal不光有创建它时的一个强引用, 还有Entry中的弱引用
    //
    //这里ThreadLocal用弱引用, 那么当失去了强引用, 仅一个弱引用就会直接被回收, 就不会产生内存泄露
    //
    //但是key被回收了, value由于key不存在了, 会一直在map中,无法回收, 就产生了泄漏
    //
    //所以使用ThreadLocal里需要在结尾处使用: tl.remove();
    //把这个kv记录给删掉

    // 虚引用 phantomReference
//    phantom n.	幻影; 幽灵; 幻象; 鬼; 鬼魂; 幻觉;
//    adj.	幻象的; 像鬼的; 幽灵似的; 幻觉的; 虚幻的;



    public static void main(String[] args) {
        WeakHashMap m = new WeakHashMap<>();

        ThreadLocal tl = new ThreadLocal();
        tl.set(m);
    }
}
