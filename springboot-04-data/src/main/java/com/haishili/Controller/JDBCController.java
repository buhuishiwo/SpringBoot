package com.haishili.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author haishili
 * @date 2025/4/21
 */
@RestController
public class JDBCController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("/select")
    public String select() {
        String sql = "select * from tb_user";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return maps.toString();
    }

    @GetMapping("/add")
    public String adduser() {
        String sql = "insert into tb_user(username,password,gender,addr) values('早八',123,'男','杭州')";
        return String.valueOf(jdbcTemplate.update(sql));
    }


}
