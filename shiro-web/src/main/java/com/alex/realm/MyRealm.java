package com.alex.realm;

import com.alex.bean.User;
import com.alex.mapper.UserMapper;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.Permissions;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 2017/5/30.
 */
public class MyRealm extends AuthorizingRealm {

    /*
    *
    *报错因为idea 工具问题
    * */
    @Autowired
    private UserMapper userMapper;

    /**
     * 授权方法
     *
     * @param principals 这个对象封装了用户的身份信息
     * @return
     */


    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        /*
        *
        * 从数据库中查询出用户的权限
        * */

        List<String> permissions = this.userMapper.getResourceByName((String) principals.getPrimaryPrincipal());

        simpleAuthorizationInfo.addStringPermissions(permissions);

        return simpleAuthorizationInfo;
    }

    /**
     * 认证方法
     *
     * @param token 这个对象封装了用户的身份和密码信息
     * @return
     * @throws AuthenticationException
     */


    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        User user = this.userMapper.getUserByName((String) token.getPrincipal());

        System.out.println(user);

        if (user!=null){
            return new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), ByteSource.Util.bytes(user.getSalt()), getName());
        }

        return null;

    }
}
