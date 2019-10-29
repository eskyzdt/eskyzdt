package cn.eskyzdt.modules.controller;

import cn.eskyzdt.modules.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping("/index")
    public String showIndex(){
        return "index";
    }
}