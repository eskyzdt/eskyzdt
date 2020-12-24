package cn.eskyzdt.modules.optional;

import java.util.Objects;
import java.util.Optional;

public class OptionalTest {

    public static void main(String[] args) {
        ab();
        // lambda双冒号的使用
         new OptionalTest().LambdaUse();

        // 通过empty创建的
        getEmptyTest();

        // 通过of创建的元素
        getOfTest();

        // 通过ofNullable创建
        getOfNullable();
    }

    /**
     * 对一个空的Optional进行get,会抛出NoSuchElementException
     */
    private static void getEmptyTest() {
        System.out.println("1. getEmptyTest() start ");
        // 如果
        Optional<String> empty = Optional.empty();
        // 这里异常
        String s = null;
        try {
            s = empty.get();
        } catch (Exception e) {
            System.out.println("getEmptyTest(): getEmptyTest throw an exception");
            System.out.println();
            // e.printStackTrace();
        }
    }

    /**
     * 通过of的方式创建
     */
    private static void getOfTest() {
        System.out.println("2. getOfTest() start ");
        Optional<String> optionalVar = Optional.of("  value from getOfTest()");
        String s = optionalVar.get();
        System.out.println("通过get()方法获取值  " + s);
        String dd = optionalVar.orElseThrow(null);
        System.out.println("通过orelseThrow获取值  " + dd);

        Optional<String> optionalVarNull = null;
        try {
            optionalVarNull = Optional.of(null);
        } catch (Exception e) {
            System.out.println("exception when created by of(null)");
        }
        String nullVar = null;
        try {
            nullVar = optionalVarNull.get();
        } catch (Exception e) {
            System.out.println("nullVar throw an exception");
            System.out.println();
        }

        // InnerTest innerTest = new InnerTest(null);
    }

    private static void getOfNullable() {
        System.out.println("3. getOfNullable() start ");
        Optional<Object> o = Optional.ofNullable(null);
        try {
            Object o2 = o.orElseThrow(NullPointerException::new);
        } catch (NullPointerException e) {
            System.out.println(" Object o2 = o.orElseThrow(NullPointerException::new); 抛出异常");
        }
        Object o1 = null;
        try {
            o1 = o.get();
        } catch (Exception e) {
            System.out.println("getOfNullable throw an exception");
        }
    }


    /**
     * Optional的创建使用了Objects.requireNonNull
     */
    public static class InnerTest {

        private String value;

        public InnerTest(String value) {
            // 这样生成的构造方法,如果value为空会抛出空指针异常
            this.value = Objects.requireNonNull(value);
        }
    }


    /**
     * 调用空参构造方法的新方式   OptionalTest::new 即 类名::方法名
     *
     * 生成一个runnable的实现类
     */
    public OptionalTest() {
        System.out.println("构造方法");
    }

    public static void aa() {
        System.out.println("11111");
    }

    public void LambdaUse() {
        // 调用构造方法
        Runnable runnableOne = OptionalTest::new;
        // 调用aa方法
        Runnable runnableTwo = OptionalTest::aa;
        // ::的方式可以直接把该方法变为runnable方法的实现
        System.out.print("runnableOne.run() : ");
        runnableOne.run();
        System.out.print("runnableTwo.run() : ");
        runnableTwo.run();

    }


    /**
     * Optional可以替代三目运算符
     */
    private static void t() {
//        Date startTime = new Date(Optional.of(req.getFromTime())
//                .orElseThrow(() -> new MessagePopException("开始时间不能为空")));

        // 写成上面的形式就不用写成下面的形式了
//
//        if(req.getFromTime() == null){
//            throw new MessagePopException("开始时间不能为空");
//        }
//        Date startTime = req.getFromTime();

        //1、非常简单的三目运算符  如果是null，就返回1  否则返回里面的值
        Integer v = Optional.<Integer>ofNullable(null).orElse(1);
        System.out.println(v); //1

        Optional<String> s = Optional.<String>ofNullable(null);
        //2、三目运算符  结合map  可以实现类型的转换 非常安全且强大
        Integer vvv = Optional.<String>ofNullable(null).map(x -> Integer.valueOf(x)).orElse(100);
        System.out.println(vvv); //100

    }

    private static void ab() {
        Integer integer = Optional.ofNullable(1).orElse(10);
        Integer integer2 = Optional.of(1).orElse(10);
        System.out.println(integer);
        System.out.println(integer2);

        Optional<Integer> optional = Optional.<Integer>ofNullable(null);
        Integer integer1 = optional.orElseGet(() -> 22);

        System.out.println(integer1);

        Integer integer3 = optional.orElse(10);
        Integer integer4 = null;
        try {
            integer4 = Optional.of((Integer)null).orElse(10);
        } catch (Exception e) {
           // e.printStackTrace();
        }
        // 也可这样写Integer integer5 = Optional.<Integer>of(null).orElse(10);
        System.out.println(integer3);
        System.out.println(integer4);
    }
}
