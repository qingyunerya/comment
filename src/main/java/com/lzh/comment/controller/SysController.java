package com.lzh.comment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SysController {

    @RequestMapping({"/","/index"})
    public String toIndex(Model model){
        model.addAttribute("msg","Hello Shiro");
        return "index";
    }
    @RequestMapping("/toLogin")
    public String toLogin(Model model){
        model.addAttribute("msg","Hello Shiro");
        return "login";
    }


}
