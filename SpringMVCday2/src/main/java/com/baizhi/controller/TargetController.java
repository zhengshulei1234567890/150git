package com.baizhi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/target")
public class TargetController {
    @RequestMapping("/A")
    public String A()throws Exception{
        return "index";
    }
}
