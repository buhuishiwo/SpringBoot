package com.haishili.shiro.realm;

import com.haishili.shiro.entity.User;
import com.haishili.shiro.mapper.UserMapper;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.lang.util.ByteSource;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author haishili
 * @date 2025/4/28
 */
@Component
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UserMapper userMapper;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //1.获取传入用户信息
        //方法一
        //String username = authenticationToken.getPrincipal().toString();
        //方法二
        String username = null;
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        username = usernamePasswordToken.getUsername();
        //2.获取数据库用户信息
        User user = userMapper.findByName(username);
        //3.判断信息
        if (user == null) {
            throw new UnknownAccountException("用户不存在");
        }
        return new SimpleAuthenticationInfo(
                user.getName(),
                user.getPwd(),
                //配置加盐信息
                ByteSource.Util.bytes("md5"),
                getName()
        );
    }
}
