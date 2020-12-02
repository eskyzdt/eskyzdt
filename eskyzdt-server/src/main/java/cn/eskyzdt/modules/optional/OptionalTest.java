package cn.eskyzdt.modules.optional;

import java.util.Objects;
import java.util.Optional;

public class OptionalTest {

    public static void main(String[] args) {
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
        Optional<String> optionalVar = Optional.of("getOfTest(): create by method of");
        String s = optionalVar.get();
        System.out.println(s);

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


}
