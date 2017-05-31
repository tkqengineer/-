package com.alex.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.security.Permissions;
import java.util.ArrayList;

/**
 * Created by Alex on 2017/5/30.
 */
public class MyRealm extends AuthorizingRealm {

    /**
     * 授权方法
     *
     * @param principals 这个对象封装了用户的身份信息
     * @return
     */


    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        ArrayList<String> permissions = new ArrayList<String>();

        permissions.add("create:user:add");
        permissions.add("create:user:update");
        permissions.add("create:user:delete");

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

        return new SimpleAuthenticationInfo("alex", "1c7e3d68884894ebeb954f75f865fb80", ByteSource.Util.bytes("aaa"), getName());
    }
}
