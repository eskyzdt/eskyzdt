package cn.eskyzdt.modules.designmodule.proxypattern;

/**
 * 需要被代理的类
 */
public class Target {

    private String a;

    private String b;

    public Target() {
    }

    public Target(String a, String b) {
        this.a = a;
        this.b = b;
    }

    public void run(String a, String b) {
        System.out.println(a + b );
    }

}
