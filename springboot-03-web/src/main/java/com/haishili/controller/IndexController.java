package com.haishili.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author haishili
 */
@Controller
public class IndexController {

    @RequestMapping({"/","/index.html"})
    public String index() {
        return "index";
    }


}

