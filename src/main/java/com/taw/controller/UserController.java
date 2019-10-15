package com.taw.controller;

import com.taw.Service.DeptService;
import com.taw.Service.RoleService;
import com.taw.Service.UserService;
import com.taw.bean.Dept;
import com.taw.bean.Role;
import com.taw.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private DeptService deptService;

    @Autowired
    private RoleService roleService;

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
        int flag = 0;
        List<User> list = userService.findAll();
        List<Role> roleList = roleService.findAll();
        for (User u: list){
            Dept dept = deptService.findByid(u.getDept().getDid());
            u.setDept(dept);
            u.setRole(roleList.get(flag).getRname());
            flag++;
        }
        System.out.println(list);
        mv.addObject("list", list);
        mv.setViewName("System_User/list");
        return mv;
    }

    @RequestMapping("/delete/{uid}.do")
    public String deleteUserById(@PathVariable("uid") int uid){
        userService.deleteUserById(uid);
        return "redirect:/user/findAll.do";
    }

    @RequestMapping("updateUser/{uid}.do")
    public ModelAndView updateUser(@PathVariable("uid") int uid) {
        ModelAndView mv = new ModelAndView();
        User user = userService.findByUid(uid);
        List<Dept> deptList = deptService.findAll();
        mv.addObject("user", user);
        mv.addObject("deptList", deptList);
        mv.setViewName("/System_User/saveUI222");
        return mv;
    }

    @RequestMapping("update.do")
    public ModelAndView update(HttpServletRequest request) {
        User user = new User();
        ModelAndView mv = new ModelAndView();
        user.setUid(Integer.parseInt(request.getParameter("uid")));
        user.setLoginName(request.getParameter("loginName"));
        user.setName(request.getParameter("name"));
        user.setSex(request.getParameter("sex"));
        user.setPhone(request.getParameter("phoneNumber"));
        user.setEmail(request.getParameter("email"));
        user.setDescip(request.getParameter("description"));
        user.setDid(Integer.parseInt(request.getParameter("did")));
        if(userService.check(user)==null){
            userService.updateUser(user);
            mv.setViewName("redirect:/user/findAll.do");
        }else{
            mv.addObject("user", user);
            mv.setViewName("System_User/saveUI222");
            mv.addObject("message", "登录名重复");
        }
        return mv;
    }

    @RequestMapping("resetPassword/{uid}.do")
    public String resetPassword(@PathVariable("uid") int uid){
        userService.resetPassword(uid);
        return "redirect:/user/findAll.do";
    }

    @RequestMapping("insertUserlist.do")
    public ModelAndView insertUserList(){
        ModelAndView mv = new ModelAndView();
        List<Dept> deptList = deptService.findAll();
        mv.addObject("deptList", deptList);
        mv.setViewName("System_User/saveUI");
        return mv;
    }

    @RequestMapping("register.do")
    public String register(HttpServletRequest request){
        User user = new User();
        user.setLoginName(request.getParameter("loginName"));
        user.setPassword("1234");
        user.setName(request.getParameter("name"));
        user.setSex(request.getParameter("sex"));
        user.setPhone(request.getParameter("phoneNumber"));
        user.setEmail(request.getParameter("email"));
        user.setDescip(request.getParameter("description"));
        user.setDid(Integer.parseInt(request.getParameter("did")));
        if (userService.check(user) == null){
            userService.register(user);
        }
        return "redirect:/user/findAll.do";
    }
}