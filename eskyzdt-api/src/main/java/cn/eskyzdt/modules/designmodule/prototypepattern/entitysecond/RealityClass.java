package cn.eskyzdt.modules.designmodule.prototypepattern.entitysecond;


public class RealityClass extends AbstractClasss {

    private String a;

    private String b;

    public RealityClass () {

    }

    public RealityClass(String a, String b) {
        this.a = a;
        this.b = b;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }
}
