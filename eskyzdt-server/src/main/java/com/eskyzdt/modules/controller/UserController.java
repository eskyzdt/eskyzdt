package com.eskyzdt.modules.controller;

import com.eskyzdt.modules.entity.User;
import com.eskyzdt.modules.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

}
