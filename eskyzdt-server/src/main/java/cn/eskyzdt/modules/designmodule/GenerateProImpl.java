package cn.eskyzdt.modules.designmodule;

import cn.eskyzdt.modules.designmodule.simplefactory.Computer;
import cn.eskyzdt.modules.designmodule.simplefactory.Phone;
import cn.eskyzdt.modules.designmodule.simplefactory.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@ResponseBody
public class GenerateProImpl {

    public Product generatePro(Object a) {
        if (a instanceof Phone) {
            return ((Phone) a).make();
        }
        if (a instanceof Computer) {
            return ((Computer) a).make();
        }
        return null;
    }

    /**
       这种是简单工厂模式
        产品都由一个工厂生产
     */
    public void test() {
        GenerateProImpl generatePro = new GenerateProImpl();
        Phone phone = new Phone();
        generatePro.generatePro(phone);
    }

}
