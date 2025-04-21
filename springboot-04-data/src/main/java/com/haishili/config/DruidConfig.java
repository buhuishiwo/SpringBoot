package com.haishili.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.jakarta.StatViewServlet;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

/**
 * @author haishili
 * @date 2025/4/21
 */
@Configuration
public class DruidConfig {
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DruidDataSource druidDataSource() {
        return new DruidDataSource();
    }

    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean<StatViewServlet> statViewServletServletRegistrationBean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        HashMap<String, String> initParameters = new HashMap<>();
        initParameters.put("loginUsername", "admin");
        initParameters.put("loginPassword", "123456");


        statViewServletServletRegistrationBean.setInitParameters(initParameters);
        return statViewServletServletRegistrationBean;
    }
}
