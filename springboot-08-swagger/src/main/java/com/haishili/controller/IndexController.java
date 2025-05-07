package com.haishili.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author haishili
 * @date 2025/5/3
 */
@RestController
public class IndexController {
    @Operation(
            summary = "hello",
            description = "hello 链接"
    )
    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }
}
