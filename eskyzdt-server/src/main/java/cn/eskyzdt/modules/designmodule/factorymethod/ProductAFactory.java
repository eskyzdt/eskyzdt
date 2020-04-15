package cn.eskyzdt.modules.designmodule.factorymethod;

public class ProductAFactory implements Factory {
    @Override
    public Product make() {
        return new ProductA();
    }

    @Override
    public Computer makeComputer() {
        return new ComputerA();
    }
}
