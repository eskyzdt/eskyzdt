package cn.eskyzdt.modules.controller;

import cn.eskyzdt.modules.user.entity.User;
import cn.eskyzdt.modules.user.entity.UserDto;
import cn.eskyzdt.modules.user.service.UserService;
import com.baomidou.mybatisplus.extension.api.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    public String findAll(){
        return "aaa";
    }

    @RequestMapping("/findById/{id}")
   // @ResponseBody   //要有ResponseBody,才能在页面展示(之前没写RestController)
    public User findById(@PathVariable Integer id){
        return userService.findById(id);
    }

    @RequestMapping("/findById2/{id}")
    // @ResponseBody   //要有ResponseBody,才能在页面展示(之前没写RestController)
    public UserDto findById2(@PathVariable Integer id){
        return userService.findById2(id);
    }

    @RequestMapping("/findByIdR/{id}")
    // @ResponseBody   //要有ResponseBody,才能在页面展示(之前没写RestController)
    public R findByIdR(@PathVariable Integer id){
        return userService.findByIdR(id);
    }

    @RequestMapping(value = "/annoTest",method = RequestMethod.GET)
    public UserDto annoTest(@RequestParam UserDto userDto){
        UserDto u = new UserDto();
        u.setId(5);
        UserDto user = userService.findUser(u);
        boolean b = userService.insertUser(userDto);
        return user;
    }


}
