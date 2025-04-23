package com.haishili.controller;

import com.haishili.mapper.UserMapper;
import com.haishili.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author haishili
 * @date 2025/4/22
 */
@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/findall")
    public List<User> findAll() {
        return userMapper.findAll();
    }
}
