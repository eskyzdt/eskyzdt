package cn.eskyzdt.modules.designmodule.proxypattern;

/**
 * 代理类
 */
public class ProxyT {

    public void run() {
        String a = "1";
        String b = "2";
        new Target().run(a, b);
    }

    public static void main(String[] args) {
        new ProxyT().run();
    }

}
