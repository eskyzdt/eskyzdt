package cn.eskyzdt.modules.lambda;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ForEach {

/**
 * 我们可以将 lambda 表达式定义为一种 简洁、可传递的匿名函数，
 * 首先我们需要明确 lambda 表达式本质上是一个函数，
 * 虽然它不属于某个特定的类，但具备参数列表、
 * 函数主体、返回类型，甚至能够抛出异常；
 * 其次它是匿名的，lambda 表达式没有具体的函数名称；lambda 表达式可以像参数一样进行传递，从而简化代码的编写，其格式定义如下：
 *
 * 参数列表 -> 表达式参数列表 -> {表达式集合}
 *
 * 需要注意 lambda 表达式隐含了 return 关键字，
 *  重点: 所以在单行的表达式中，我们无需显式的写 return 关键字，
 * 如: () -> 42
 *
 * 但是当表达式是一个语句集合的时候则需要显式添加 return 关键字，并用花括号{ } 将多个表达式包围起来
 * 如(int x, int y ) -> {
 *     x = x +y;
 *     return x;
 *
 * }
 *
 *
 */


    /**
     * java8的 forEach语法糖
     *
     */
    public static void main(String[] args) {
        List<String> list =  new ArrayList<>();
        for (String s : list) {
            System.out.println(s);
        }

        Map<String, Object> keyMap = new LinkedHashMap<>();
        LocalDate date = LocalDate.now();
        for (int i = 0; i < 12; i++) {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM");
            keyMap.put(date.format(dateTimeFormatter) , "0");
            date = date.minusMonths(1);
        }
        keyMap.forEach( (x,y) -> {
            System.out.print(x);
            System.out.print(":");
            System.out.print(y);
            System.out.println();
        });

        TreeSet<String> strings = new TreeSet<>();
        strings.add("1");
        strings.add("2");
        // 这两个效果一样
        // println是有入参的函数,这种写法意思就是所有的参数都传入到里面再运行, 是forEach的
        strings.forEach(System.out::println);
        strings.forEach(x -> System.out.println(x));

        // ::的用法 以getStr()方法为例
        // 1.想调用ForEach类中的getStr
        ForEach forEach = new ForEach();
        // 2.因为getStr不是静态方法,所以要用new出来的forEach调用,如果是静态方法,那么可以直接用 ForEach::getStr
        // 注意这里::后面只需要方法名就可以了,不需要加括号
        // 例: ForEach getStr = forEach::getStr(); 报错,编译不通过
        Runnable getStr = forEach::getStr;
        // 3.上面的返回值必须是个functional interface函数式接口,即必须有一个抽象方法,不然会报错
        // The target type of this expression must be a functional interface
        // 而且编译期就通不过
        // 这里我们选择Runnable接口,因为他的run方法同样是不需要入参的
        // 4. 调用接口中的run方法.这里执行的实际上是runnable接口的实现类(即当前这个ForEach类)中的getStr()方法
        // 因为是用 forEach::getStr创建的
        getStr.run();

        //5. ::new也可以创建一个Runnable
        Runnable aNew = ForEach::new;
        // 在run()方法运行时,会调用构造方法
        aNew.run();

    }


    private void getStr() {
        System.out.println("sdfsdfsdfsdf");
    }


    /**
     * removeIf语法糖
     * 里面只能放一个语句
     *
     * 在lambda中的变量必需是effectively final
     *
     * effectively final的定义.. starting in Java SE 8, a local class can access local variables and parameters of the enclosing block that are final or
     * effectively final. A variable or parameter whose value is never changed after it is initialized is effectively final.
     *
     *    list.removeIf(item->
     *             item.getCarNumber() == null
     *             );
     */

}
