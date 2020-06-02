package cn.eskyzdt.modules.designmodule.adapterpattern;

public class AdapterClass {

    private AdapteeClass adapteeClass = new AdapteeClass();

    void xxx2() {
        System.out.println("我们在adapterClass类中使用了adapteeClass的xxx方法");
        adapteeClass.xxx();
    }

    public static void main(String[] args) {
        System.out.println("这个叫对象适配器,因为把想要用到的类adapteeClass当作一个属性放在了适配器的类中");
        AdapterClass adapterClass = new AdapterClass();
        adapterClass.xxx2();
    }



}
