package com.haishili.config;

import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author haishili
 * @date 2025/4/28
 */
@Configuration
public class ShiroConfig {
    // 注入自定义 Realm
    @Bean
    public Realm realm() {
        return new MyCustomRealm();
    }
    // 定义过滤链：/secure 需要登录，其他路径匿名访问
    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition() {
        DefaultShiroFilterChainDefinition chain = new DefaultShiroFilterChainDefinition();
        chain.addPathDefinition("/add", "authc");
        chain.addPathDefinition("/**", "anon");
        return chain;
    }
}
