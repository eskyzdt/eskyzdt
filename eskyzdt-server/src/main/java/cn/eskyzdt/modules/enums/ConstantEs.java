package cn.eskyzdt.modules.enums;

/**
 * 常量类
 *
 */

/**
 * 这里应该加上public
 * public enum ConstantEs
 */
enum ConstantEs {

    // 这里是常量的每个成员
    ONE("1", 2),
    TWO("2342", 4);

    // 这里是成员的构造字段
    private String a;
    private int b;

    // 需要改成下面这种,避免值被修改,另外,如果用了final,那么每个enum都需要有每个构造方法
    // 所以这里不能有空参构造,如果想有空参构造,则需要把每个enum的空参构造也写出来,
    //  例: 在原    ONE("1", 2),
    //    TWO("2342", 4)后加上ONE(),TWO()
   // private final String a;
   // private final int b;

    // 这里是字段的构造函数
    ConstantEs(String a,int b) {
        this.a = a;
        this.b = b;
    }

    // 这里弄一个获取常量中的数据的方法
    String getCon() {
        return a;
    }


    public static void main(String[] args) {
        System.out.println(ConstantEs.ONE);
        ConstantEs[] values = ConstantEs.values();
        System.out.println(values);
        for (ConstantEs value : values) {
            System.out.println(value);
        }

        String con = ConstantEs.ONE.getCon();
        System.out.println(con);

    }

}
