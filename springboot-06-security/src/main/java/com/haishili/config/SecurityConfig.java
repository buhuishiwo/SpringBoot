package com.haishili.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


/**
 * @author haishili
 * @date 2025/4/23
 * 别忘了加上@Configuration注解
 */
@Configuration
@EnableWebSecurity
//spring security后续版本已不需要继承WebSecurityConfigurerAdapter
public class SecurityConfig  {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests ->authorizeRequests
                        .requestMatchers("/","/toLogin","/logout").permitAll()
                        .requestMatchers("/level1/**").hasAnyRole("vip1","vip2")
                        .requestMatchers("/level2/**").hasRole("vip2")
                        .requestMatchers("/level3/**").hasRole("vip3")
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/login")
                        //一定要设置登录成功跳转链接，否则会出现跳转到其他页面的情况
                        .successForwardUrl("/")
                        .permitAll()
                )
                //此方法已被废弃
                //.logout();
                .csrf(AbstractHttpConfigurer::disable)

                .logout(httpSecurityLogoutConfigurer -> httpSecurityLogoutConfigurer
                        .logoutSuccessUrl("/")
                )
                .rememberMe(httpSecurityRememberMeConfigurer -> httpSecurityRememberMeConfigurer
                        .rememberMeParameter("remember")
                        .rememberMeCookieName("remember")
                        .userDetailsService(userDetailsService())
                );
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails vip1 = User.builder()
                .username("vip1")
                .password(passwordEncoder().encode("123456"))
                .roles("vip1")
                .build();
        UserDetails vip2 = User.builder()
                .username("vip2")
                .password(passwordEncoder().encode("1234567"))
                .roles("vip2")
                .build();
        return new InMemoryUserDetailsManager(vip1,vip2);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
