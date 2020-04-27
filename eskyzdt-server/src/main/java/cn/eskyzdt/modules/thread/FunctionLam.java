package cn.eskyzdt.modules.thread;

/**
 * @FunctionalInterface注解Java 8为函数式接口引入了一个新注解@FunctionalInterface，
 * 主要用于编译级错误检查，加上该注解，当你写的接口不符合函数式接口定义的时候，编译器会报错。
 */

@FunctionalInterface
/**
 * 加不加@FunctionalInterface对于接口是不是函数式接口没有影响，该注解知识提醒编译器去检查该接口是否仅包含一个抽象方法
 */
interface FunctionLam {

    void meOne(String message);


    /**
     * 函数式接口里是可以包含默认方法，因为默认方法不是抽象方法，其有一个默认实现，所以是符合函数式接口的定义的；
     */
    /**
     * 在java8以后，接口中可以添加使用default或者static修饰的方法，在这里我们只讨论default方法，default修饰方法只能在接口中使用，在接口种被default标记的方法为普通方法，可以直接写方法体。
     *
     * 如果接口A中有default方法：Test类实现接口A： 那么Test类将会继承接口A中的a方法： 如果一个类同时实现接口A和B，接口A和B中有相同的default方法，这时，该类必须重写接口中的default方法
     * 如果子类继承父类，父类中有b方法，该子类同时实现的接口中也有b方法（被default修饰），那么子类会继承父类的b方法而不是继承接口中的b方法
     */
    default void meTwo() {

    };

    /**
     * 函数式接口里是可以包含静态方法，因为静态方法不能是抽象方法，是一个已经实现了的方法，所以是符合函数式接口的定义的；
     */
    static String meStatic() {
        return "静态方法";
    }

    /**
     * 函数式接口里是可以包含Object里的public方法，这些方法对于函数式接口来说，
     * 不被当成是抽象方法（虽然它们是抽象方法）；因为任何一个函数式接口的实现，默认都继承了Object类，包含了来自java.lang.Object里对这些抽象方法的实现；
     */
    @Override
    boolean equals(Object obj);

    /**
     * 必须是Object类中修饰符为public的才可以
     * 而clone()是protected类的,所以不可以
     *
     * @return
     */
    @Override
    int hashCode();

}
