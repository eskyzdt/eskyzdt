package cn.eskyzdt.modules.designmodule.templatemodule;

public class SubClass extends AbstractClass {
    @Override
    void meFir() {
        System.out.println("`111111");
    }

    @Override
    void meSec() {
        System.out.println("22222");
    }


    public static void main(String[] args) {
        SubClass subClass = new SubClass();
        subClass.mainMethod();
    }
}
