package com.haishili.shiro.service;

import com.haishili.shiro.entity.User;
import org.springframework.stereotype.Service;

/**
 * @author haishili
 * @date 2025/4/28
 */
@Service
public interface UserService {
    User findByname(String name);
}
