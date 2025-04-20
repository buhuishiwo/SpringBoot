package com.haishili.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author haishili
 * @date 2025/4/16
 */
@Controller
public class UserController {
    @RequestMapping("/user/login")
    //不使用@RequestParam注解也能获取到请求参数，但是不支持复杂对象，比如pojo对象
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model,
            HttpSession session) {
        if(StringUtils.hasText(username) && StringUtils.hasText(password) && "123456".equals(password) && "admin".equals(username)) {
            session.setAttribute("loginUser", username);
            return "redirect:/main.html";
        }else{
            model.addAttribute("msg","用户名或密码错误");
            return "index";
        }
    }
    @RequestMapping("/signout")
    public String signOut(HttpSession session) {
        if(session.getAttribute("loginUser") != null) {
            session.removeAttribute("loginUser");
        }
        return "index";
    }
}
