package com.alex.shiro.realm;

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
	
	//授权的方法,在授权的时候回调
	
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		return null;
	}
	
	//认证的方法,在认证的时候回调
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		
		//在回调的token获取用户名(用户在token中传入的)
		String userName = (String) authenticationToken.getPrincipal();
		//在回调的token获取密码(用户在token中传入的)
		String password = String.valueOf((char[]) authenticationToken.getCredentials());
		
		//返回的userName 和password 如果和 用户传入的一致则认证通过
		//在生产环境userName 和password 需要查询数据库做验证
		
		/*
		*
		* 返回null值会抛出用户不存在异常
		*
		* 适合在查询数据库后发现用户不存在
		*
		* return null;
		*
		* */
		
		/*
		*
		* 如果password 和传入的password值不一样会抛出凭证不匹配异常
		* 适合在查询数据库后发现用户存在但是密码不存在
		*
		*
		* */
		
		return new SimpleAuthenticationInfo(userName,password,this.getName());
	}
}
