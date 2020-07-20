package cn.eskyzdt.modules.enums;

/**
 * 常量类
 *
 */
enum ConstantEs {

    // 这里是常量的每个成员
    ONE("1", 2),
    TWO("2342", 4);

    // 这里是成员的构造字段
    private String a;
    private int b;

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
