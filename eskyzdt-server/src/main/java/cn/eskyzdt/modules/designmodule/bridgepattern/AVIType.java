package cn.eskyzdt.modules.designmodule.bridgepattern;

public class AVIType implements MovieType {

    @Override
    public void resolve(String file) {
        System.out.println("AVIType resolved:" + file);
    }

}
