package com.haishili.shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author haishili
 * @date 2025/4/29
 */
@Controller
@RequestMapping("/myController")
public class MyController {
    @GetMapping("/userLogin")
    @ResponseBody
    public String userLogin(String username, String password) {
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(usernamePasswordToken);
            return "success";
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("登录失败");
            return "error";
        }
    }


}
