package cn.eskyzdt.modules.designmodule.bridgepattern;

public class MP4Type implements MovieType {

    @Override
    public void resolve(String file) {
        System.out.println("MP4Type resolved:" + file);
    }
}
