package cn.eskyzdt.modules.designmodule.componentpattern;

public abstract class Component {

   String name;

    public Component(String name) {
        this.name = name;
    }

    public abstract void display(int depth);
}
