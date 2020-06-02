package cn.eskyzdt.modules.designmodule.bridgepattern;

public class Linux extends SystemAb {

    public Linux(MovieType type) {
        super(type);
    }

    @Override
    void run() {
        type.resolve("在linux下运行");
    }
}
