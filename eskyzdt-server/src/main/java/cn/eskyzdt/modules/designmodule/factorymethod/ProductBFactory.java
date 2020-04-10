package cn.eskyzdt.modules.designmodule.factorymethod;

public class ProductBFactory implements Factory {
    @Override
    public Product make() {
        return new ProductB();
    }

    @Override
    public Computer makeComputer() {
        return new ComputerB();
    }
}
