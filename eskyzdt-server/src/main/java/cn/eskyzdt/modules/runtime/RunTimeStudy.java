package cn.eskyzdt.modules.runtime;

public class RunTimeStudy {

    public void test01() {

        Runtime runtime = Runtime.getRuntime();
        long l = runtime.maxMemory();
        System.out.println(l);
        System.out.println(runtime.freeMemory());
        System.out.println(runtime.totalMemory());
        System.out.println("==================================");
        runtime.exit(1);

        // 可调用系统代码
        // Runtime.getRuntime().exec("cmd /c start cls ");
        // Runtime.exit()可关闭虚拟机

    }

}
