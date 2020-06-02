package cn.eskyzdt.modules.designmodule.adapterpattern;

public class ShipeileiImpl extends AdapteeClass implements Shipeilei {
    @Override
    public void xxxaaa() {
        super.xxx();
    }

    public static void main(String[] args) {
        System.out.println("类适配器模式");
        ShipeileiImpl shipeilei = new ShipeileiImpl();
        shipeilei.xxxaaa();
    }

}
