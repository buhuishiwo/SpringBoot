package com.haishili.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author haishili
 * @date 2025/4/27
 */
@Controller
public class MyController {
    @RequestMapping({"/","/index"})
    public String toIndex() {
        return "index";
    }

    @RequestMapping("/add")
    public String add() {
        return "user/add";
    }

    @RequestMapping("/update")
    public String update() {
        return "user/update";
    }
}
