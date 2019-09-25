package com.taw.controller;

import com.taw.Service.UserService;
import com.taw.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "login.do", method = RequestMethod.POST)
    public String Login(@RequestParam("loginName") String loginName, @RequestParam("password") String password){
        System.out.println("doing: login.do");
        User user = userService.login(loginName,password);
        if (user != null){
        return "index";
    }else {
            return "redirect:/";
        }
    }
}
