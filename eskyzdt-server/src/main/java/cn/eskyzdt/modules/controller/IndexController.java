package cn.eskyzdt.modules.controller;

import cn.eskyzdt.modules.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/")
public class IndexController {

  /*  @RequestMapping("/")
    public void index(HttpServletResponse response) throws IOException {
        response.sendRedirect("index");
    }*/

    // 在配置文件引用zeus的情况下,这里的值为eee,因为springboot读取配置文件是由上到下的
    @Value("${fugai.sss}")
    private String value;

    @RequestMapping("/index")
    public String showIndex(){
        return "index";
    }

    @RequestMapping("/index2")
    @ResponseBody
    public String showIndex2(){
        return this.value;
    }
}