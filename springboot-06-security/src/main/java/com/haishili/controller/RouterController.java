package com.haishili.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author haishili
 * @date 2025/4/23
 */
@Controller
public class RouterController {
    @RequestMapping({"/","/index"})
    public String index() {
        return "index";
    }
    @RequestMapping("/login")
    public String toLogin() {
        return "views/login";
    }
    @RequestMapping("/level1/{id}")
    public String view1(@PathVariable("id") int id) {
        return "views/level1/"+id;
    }
    @RequestMapping("/level2/{id}")
    public String view2(@PathVariable("id") int id) {
        return "views/level2/"+id;
    }
    @RequestMapping("/level3/{id}")
    public String view3(@PathVariable("id") int id) {
        return "views/level3/"+id;
    }
//    @PostMapping("/login")
//    public String login() {
//        return "index";
//    }
}
