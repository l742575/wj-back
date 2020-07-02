package com.ida.wj.shiro;

import com.ida.wj.pojo.User;
import com.ida.wj.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author lh
 * @date 2020/6/9
 * @description
 */
public class MyRealm  extends AuthorizingRealm {
    @Autowired
    UserService userService;
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
       SimpleAuthorizationInfo s= new SimpleAuthorizationInfo();
       return s;
    }
   //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //验证账号
        String username = token.getPrincipal().toString();
        User user = userService.findUserByUsername(username);
        if (user == null){
            throw new UnknownAccountException();
        }
        /*if(Boolean.TRUE.equals(user.getLocked())) {
            throw new LockedAccountException(); //帐号锁定
        }*/
        //最后的比对需要交给安全管理器
        //三个参数进行初步的简单认证信息对象的包装
        String password = user.getPassword();
        String salt = user.getSalt();
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(username,password, ByteSource.Util.bytes(salt),getName());
        return authenticationInfo;
    }
}
