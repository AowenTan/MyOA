package com.taw.controller;

import com.taw.Service.RoleService;
import com.taw.bean.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("list",roleService.findAll());
        mv.setViewName("/System_Role/list");
        return mv;
    }

    @RequestMapping("/delete/{rid}.do")
    public String deleteRole(@PathVariable("rid") int rid){
        roleService.deleteRoleById(rid);
        return "redirect:/role/findAll.do";
    }

    @RequestMapping("updateRole/{rid}.do")
    public ModelAndView updateRole(@PathVariable("rid") int rid){
        ModelAndView mv = new ModelAndView();
        Role role = roleService.findByRid(rid);
        mv.addObject("role", role);
        mv.setViewName("./System_Role/saveUI222");
        return mv;
    }

    @RequestMapping("update.do")
    public String update(HttpServletRequest request, @RequestParam("rid") int rid,@RequestParam("rname") String rname, @RequestParam("rdescrip") String rdescrip){
        Role role = new Role();
        role.setRid(rid);
        role.setRname(rname);
        role.setRdescrip(rdescrip);
        if (roleService.findByRname(role.getRname())==null){
            roleService.updateRole(role);
            return "redirect:/role/findAll.do";
        }else{

        }
    }
}
