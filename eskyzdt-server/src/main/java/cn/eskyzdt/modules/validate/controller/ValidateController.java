package cn.eskyzdt.modules.validate.controller;

import cn.eskyzdt.modules.validate.ValidateEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Controller
public class ValidateController {

    /**
     * 这里如果不注释掉,在打开主页时会报一个请求体为空的bug,原因未知
     * 所以@Validated 慎用
     *
     */

/*    @ResponseBody
    @RequestMapping(name = "/validate")
    public String validateTest(@Validated @RequestBody ValidateEntity entity) {

        @NotNull String name = entity.getName();
        @Future LocalDateTime tomorrow = entity.getTomorrow();
        System.out.println(
                name
        );
        System.out.println(tomorrow);
        return name;
    }*/

}
