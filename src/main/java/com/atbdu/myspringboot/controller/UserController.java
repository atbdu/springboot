package com.atbdu.myspringboot.controller;

import com.atbdu.myspringboot.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {
    @RequestMapping("/")
    public String index(Model model, HttpServletResponse response) {
        model.addAttribute("name", "simonsfan");
        return "views/index";
    }
    @GetMapping("/login")
    public String hello(User user, HttpServletRequest request){
        if (user.getUserName().equals("tom")&&user.getPassword().equals("123456")){
            request.getSession().setAttribute("userName",user.getUserName());
            request.getSession().setAttribute("password",user.getPassword());
            return "redirect:/tosucess";
        }else {
            return "views/fail";
        }

    }
    @GetMapping("/tosucess")
    public String tosucess(){
//        int i = 10/0;
        return "views/success";
    }
}
