package cn.eskyzdt.modules.controller;

import cn.eskyzdt.modules.time.MyTimeVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

@Controller
@ResponseBody
@RequestMapping("/time")
public class TimeController {

    @RequestMapping("/get")
    public MyTimeVo returnTime() {
        MyTimeVo myTimeVo = new MyTimeVo();
        myTimeVo.setCreateTime(LocalDateTime.now());
        return myTimeVo;
    }


}
