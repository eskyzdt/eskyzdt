package cn.eskyzdt.modules.designmodule.facademodule;

/**
 *
 * 门面模式
 *
 * 好处是忽略细节,只暴露给调用者自己愿意暴露的方法,比如这里只暴露a方法,各个子模块的b方法是不被调用的
 * 安全
 * 区分点: 这种模式的子模块一般是个类,是个系统,而非单纯的一个方法,一个类负责一个完整的功能
 *          内部多个方法,而使用时只需要最顶层的接口
 *  注意不要继承此FacadeClass类去实现更多新功能,此门面就是为了集中化和简化,如果去继承,就会更加复杂,违背了其初衷
 *
 */
public class FacadeClass {

    void out(String param) {

        switch (param) {
            case "1":
                ServiceFirst serviceFirst = new ServiceFirst();
                serviceFirst.a();
                break;
            case "2":
                ServiceSecond serviceSecond = new ServiceSecond();
                serviceSecond.a();
                break;
            default:
                break;
        }

    }


}
