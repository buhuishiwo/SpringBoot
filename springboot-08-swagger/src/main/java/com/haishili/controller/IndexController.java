package com.haishili.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author haishili
 * @date 2025/5/3
 */
@RestController
public class IndexController {
    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }
}
