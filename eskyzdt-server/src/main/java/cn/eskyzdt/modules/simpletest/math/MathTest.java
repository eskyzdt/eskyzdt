package cn.eskyzdt.modules.simpletest.math;

public class MathTest {

    public static void doubleT1() {
        long a = 3108915;
        double b = 1048576;
        double c = a / b;
        System.out.println(c);
        double ceil = Math.ceil(c);
        System.out.println(c + "的ceil结果为" + ceil);

        double floor = Math.floor(c);
        System.out.println(c + "的floor结果为" + floor);

    }

    public static void main(String[] args) {
        doubleT1();
    }


}
