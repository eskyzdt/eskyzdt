package cn.eskyzdt.modules.designmodule.prototypepattern;

import cn.eskyzdt.modules.designmodule.prototypepattern.entityfirst.ProtoEntity;
import cn.eskyzdt.modules.designmodule.prototypepattern.entitysecond.RealityClass;

/**
 * protoType(原型)模式 测试类
 *
 *
 * 缺点：
 * 1、配备克隆方法需要对类的功能进行通盘考虑，这对于全新的类不是很难，但对于已有的类不一定很容易，特别当一个类引用不支持串行化的间接对象，或者引用含有循环结构的时候。
 * 2、必须实现 Cloneable 接口。
 * <p>
 * 使用场景：
 * 1、资源优化场景。
 * 2、类初始化需要消化非常多的资源，这个资源包括数据、硬件资源等。
 * 3、性能和安全要求的场景。
 * 4、通过 new 产生一个对象需要非常繁琐的数据准备或访问权限，则可以使用原型模式。
 * 5、一个对象多个修改者的场景。
 * 6、一个对象需要提供给其他对象访问，而且各个调用者可能都需要修改其值时，可以考虑使用原型模式拷贝多个对象供调用者使用。
 * 7、在实际项目中，原型模式很少单独出现，一般是和工厂方法模式一起出现，通过 clone 的方法创建一个对象，然后由工厂方法提供给调用者。原型模式已经与 Java 融为浑然一体，大家可以随手拿来使用。
 *
 *
 * attention: 构造函数不会被执行
 *一个实现了Cloneable并重写了clone方法的类A，有一个无参构造或有参构造B，
 * 通过 new关键字产生了一个对象S，再然后通过S.clone()方式产生了一个新的对象T，
 * 那么在对象 拷贝时构造函数B是不会被执行的。我们来写一小段程序来说明这个问题，如代码清单13-8 所示。
 *
 * 对象拷贝时构造函数确实没有被执行，这点从原理来讲也是可以讲得通的，Object类的 clone方法的原理是从内存中（具体地说就是堆内存）以二进制流的方式进行拷贝，重新分配 一个内存块，那构造函数没有被执行也是非常正常的了。
 */
public class PrototypeTest {

    public static void main(String args[]) {
        test01();


    }


    private static void test01() {
        ProtoEntity protoEntity = new ProtoEntity();
        protoEntity.setProperty("第一个");
        ProtoEntity clone = protoEntity.clone();
        clone.setProperty("第二个");
        System.out.println(protoEntity.hashCode());
        System.out.println(protoEntity);
        System.out.println("==========================================");
        System.out.println(clone.hashCode());
        System.out.println(clone);
    }


    private static void test02() {
        RealityClass realityClass = new RealityClass();
        realityClass.setA("test 02 A");
        RealityClass clone = (RealityClass) realityClass.clone();
        clone.setA("test02 b");
        clone.setB("test02 B");
        System.out.println(realityClass);
        System.out.println(realityClass.hashCode());
        System.out.println(clone);
        System.out.println(clone.hashCode());

    }
}
