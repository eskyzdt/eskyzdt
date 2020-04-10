package cn.eskyzdt.modules.designmodule.simplefactory;

/**
 * 单一功能原则
 * 接口隔离原则
 * solid
 * single responsibility
 * o open/close
 * l 李氏 substitution 替换原则
 * i interface segregation 接口隔离
 * d dependence inversion
 *
 *
 */
public interface Product {

    /**
     * 工厂模式的生成方法
     */
    Product make();

}
