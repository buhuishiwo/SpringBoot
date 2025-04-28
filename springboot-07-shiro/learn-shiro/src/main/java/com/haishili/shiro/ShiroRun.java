package com.haishili.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.ini.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;

/**
 * @author haishili
 * @date 2025/4/27
 */
public class ShiroRun {
    public static void main(String[] args) {
        //1. 初始化获取SecurityManager
        IniSecurityManagerFactory iniSecurityManagerFactory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = iniSecurityManagerFactory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        //2. 获取Subject对象
        Subject subject = SecurityUtils.getSubject();
        //3. 创建token对象，web应用用户名密码从页面传递
        AuthenticationToken token = new UsernamePasswordToken("zhangsan", "z3");
        //4. 完成登录
        subject.login(token);
        //5. 判断是否有角色组
        boolean role2 = subject.hasRole("role2");
        //6. 判断是否有权限
        System.out.println( "是否有权限user:insert = "+ subject.isPermitted("user:insert"));
        System.out.println("是否有此角色role2 = "+role2);
        System.out.println("登录成功");
        //如果没有则抛出异常
        subject.checkPermission("user:insert");
    }
}
