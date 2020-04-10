package cn.eskyzdt.modules.designmodule.factorymethod;

import org.apache.naming.factory.BeanFactory;

public class FactoryUse {

    public static Product generatePro(String a ) {
        ProductAFactory productAFactory = new ProductAFactory();
        ProductBFactory productBFactory = new ProductBFactory();
        Product make = productAFactory.make();
        Product make1 = productBFactory.make();
        Computer computer = productAFactory.makeComputer();
        Computer computer1 = productBFactory.makeComputer();
        return null;
    }

}
