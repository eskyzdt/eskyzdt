package cn.eskyzdt.modules.designmodule.bridgepattern;

public abstract class SystemAb {

    public MovieType type;

    public SystemAb(MovieType type) {
        this.type = type;
    }

    abstract void run();

}
