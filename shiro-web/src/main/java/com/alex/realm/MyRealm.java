package com.alex.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * Created by Alex on 2017/5/26.
 */
public class MyRealm extends AuthorizingRealm {
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		return null;
	}
	
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		
		//System.out.println("需要认证");
		
		String principal = (String) authenticationToken.getPrincipal();
		char[] credentials = (char[]) authenticationToken.getCredentials();
		
		System.out.println(principal);
		System.out.println(String.valueOf(credentials));
		
		return new SimpleAuthenticationInfo("alex","123",getName());
	}
	
}
