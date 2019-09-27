package com.taw.controller;

import com.taw.Service.UserService;
import com.taw.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "login.do", method = RequestMethod.POST)
    public ModelAndView Login(@RequestParam("loginName") String loginName, @RequestParam("password") String password){
        System.out.println("doing: login.do");
        ModelAndView mv = new ModelAndView();
        User user = userService.login(loginName,password);
        if (user != null){
        mv.addObject(user);
        mv.setViewName("redirect:/index.jsp");
    }else {
        mv.setViewName("redirect:/loginUI.jsp");
        }
        return mv;
    }

    @RequestMapping("findAll.do")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<User> list = userService.findAll();
        mv.addObject("list",list);
        mv.setViewName("System_User/list");
        return mv;
    }
}
