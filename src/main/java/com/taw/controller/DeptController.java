package com.taw.controller;

import com.taw.Service.DeptService;
import com.taw.bean.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<Dept> list = deptService.findAll();
        List<String> listName = new ArrayList<String>();
        for(Dept dept : list){
            if(dept.getPid() != null){
                System.out.println("Pid: " + dept.getPid());
                Dept parent = deptService.findById(dept.getPid());
                System.out.println(parent);
                listName.add(parent.getDname());
            }else {
                listName.add(null);
            }
        }

        mv.addObject("list", list);
        mv.addObject("listName", listName);
        mv.setViewName("System_Department/list");
        return mv;
    }
}
