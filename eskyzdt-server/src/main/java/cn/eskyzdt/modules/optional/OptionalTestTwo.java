package cn.eskyzdt.modules.optional;

import java.util.Arrays;
import java.util.List;

public class OptionalTestTwo {


    public static void main(String[] args) {
        test01();
        System.out.println("===============================");
        test02();
    }


    private static void test02() {
        int a = true ? 1 : get("ggg");
        System.out.println(a);
    }

    private static void test01() {
        List<Integer> list = Arrays.asList(10, 20, 30);

        //通过reduce方法得到一个Optional类
        /**
         * 用orelse的话,即使Optional不为null, orelse中的get("a")也会执行
         * 因为该方法如下,other在orElse方法执行前已经确定值了
         *     public T orElse(T other) {
         *         return value != null ? value : other;
         *     }
         *
         *     而orelseGet未确定值,它是个supplier
         */
        int a = list.stream().reduce(Integer::sum).orElse(get("a"));
        int b = list.stream().reduce(Integer::sum).orElseGet(() -> get("b"));
        System.out.println("a  " + a);
        System.out.println("b  " + b);


        List<Integer> list2 = Arrays.asList();
        //通过reduce方法得到一个Optional类
        int a2 = list2.stream().reduce(Integer::sum).orElse(get("a"));
        int b2 = list2.stream().reduce(Integer::sum).orElseGet(() -> get("b"));
        System.out.println("a  " + a2);
        System.out.println("b  " + b2);
    }

    public static int get(String name) {
        System.out.println(name + "执行了方法");
        return 1;
    }


}
