package com.haishili.config;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @author haishili
 * @date 2025/4/28
 */
public class MyCustomRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // 从 principals 获取用户名并加载角色、权限
        info.addRole("admin");
        info.addStringPermission("articles:compose");
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken upToken = (UsernamePasswordToken) authenticationToken;
        String username = upToken.getUsername();
        // 这里可替换为数据库校验
        if (!"user".equals(username)) {
            throw new UnknownAccountException();
        }
        return new SimpleAuthenticationInfo(username, "password", getName());
    }
}
