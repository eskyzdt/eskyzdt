package cn.eskyzdt.modules.designmodule.bridgepattern;

public class Windows extends SystemAb {

    public Windows(MovieType type) {
        super(type);
    }

    @Override
    void run() {
        type.resolve("在windows下运行");
    }

}
