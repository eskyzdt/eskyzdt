package cn.eskyzdt.modules.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * java8的stream流
 *
 *
 */
public class LambdaStream {

    public static void main(String[] args) {
        Runnable run = LambdaStream::gen;
        run.run();

      /*  HashMap<String, Object> map = new HashMap<>();
        map.put("a", "1");
        map.put("b", "2");
        map.put("c", "3");
        map.put("d", "4");
        map.put("e", "5");*/

        ArrayList<String> list = new ArrayList<>(10);
        list.add("2");
        list.add("3");
        list.set(0,"3");
        list.set(1, "3");

        // 对于一个list,可以用removeIf
        list.removeIf(o->o.equals("111"));

        // 获得一个顺序流
        Stream<String> stream = list.stream();
        // 获得一个并行流
        Stream<String> stringStream = list.parallelStream();
        Integer[] num = new Integer[]{1,3,4,3};
        List<Integer> integers = Arrays.asList(num);
        System.out.println(integers);


        Stream<Integer> stream1 = integers.stream();
        long count = stream1.count();
        System.out.println("总数为" + count);

        // map可以把原先的流映射为另一个流,下面就是把String的流映射为integer流了
        List<String> list2 = new ArrayList<String>();
        list2.add("1");
        list2.add("12");
        list2.add("1");
        List<Integer> objectStream = list2.stream().map(e->Integer.parseInt(e)).collect(Collectors.toList());

    }

    /**
     * 三、方法引用（含构造方法引用）
     *
     * 通常与Lambda表达式联合使用，可以直接引用已有Java类或对象的方法。一般有四种不同的方法引用：
     *
     *     构造器引用。语法是Class::new，或者更一般的Class< T >::new，可无参，可有参数。方法签名保持一致；
     *     静态方法引用。语法是Class::static_method，要求方法签名保持一致；
     *     特定类的任意对象方法引用。它的语法是Class::method。要求方法签名保持一致；
     *     特定对象的方法引用，它的语法是instance::method。要求方法签名保持一致。与3不同的地方在于，3是在列表元素上分别调用方法，而4是在某个对象上调用方法，将列表元素作为参数传入；
     */
    private static String gen() {
        System.out.println("ccc");
        return "ccc";
    }


}
