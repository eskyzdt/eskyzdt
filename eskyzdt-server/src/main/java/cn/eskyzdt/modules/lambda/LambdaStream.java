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


}
