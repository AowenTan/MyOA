package com.taw.controller;

import com.taw.Service.DeptService;
import com.taw.Service.UserService;
import com.taw.bean.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@Controller
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @Autowired
    private UserService userService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<Dept> list = deptService.findAll();
        List<String> listName = new ArrayList<String>();
        for(Dept dept : list){
            if(dept.getPid() != null){
//                System.out.println("Pid: " + dept.getPid());
                Dept parent = deptService.findByid(dept.getPid());
//                System.out.println(parent);
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

    @RequestMapping("/delete/{did}.do")
    public String deleteById(@PathVariable("did") int did){
        Dept dept = new Dept();
        Stack<Dept> stack = new Stack<>();
        stack.push(deptService.findByid(did));

        while (!stack.empty()){
            Dept last = stack.lastElement();
            dept.setPid(last.getDid());

            List<Dept> list = deptService.findSonByPid(dept.getPid());
            if (list.size() > 0){
                for (Dept d : list){
                    stack.push(d);
                }
                continue;
            }else{
                dept = stack.pop();
                userService.deleteUserByDid(dept.getDid());
                deptService.deleteDeptById(dept.getDid());
            }
        }

        return "redirect:/dept/findAll.do";
    }
}
