package com.haishili.controller;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author haishili
 * @date 2025/4/28
 */
@Controller
public class MyController {
    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }
    @RequestMapping("/")
    public String index() {
        return "index";
    }
    @RequestMapping("/add")
    @RequiresAuthentication
    public String add() {
        return "/user/add";
    }
    @RequestMapping("/update")
    public String update() {
        return "/user/update";
    }
}
