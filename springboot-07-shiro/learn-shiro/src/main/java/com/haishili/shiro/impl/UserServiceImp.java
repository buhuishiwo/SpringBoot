package com.haishili.shiro.impl;


import com.haishili.shiro.entity.User;
import com.haishili.shiro.mapper.UserMapper;
import com.haishili.shiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author haishili
 * @date 2025/4/28
 */
@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByname(String name) {
        return userMapper.findByName(name);
    }
}
