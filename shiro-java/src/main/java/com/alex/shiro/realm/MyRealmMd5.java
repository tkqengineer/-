package com.alex.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

/**
 * Created by Alex on 2017/5/26.
 */
public class MyRealmMd5 extends AuthorizingRealm {
	
	/*
	* 授权是会回调
	*
	* */
	
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		return null;
	}
	
	/*
	*
	* 认证是会回调
	*
	* */
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		
		/*
		*
		* userName 在生产环境需要从数据库中查 如果没有 需要返回null
		*
		* */
		
		Object userName = authenticationToken.getCredentials();
		
		/*
		*
		* password 在生产环境需要从数据库查出 ,在返回
		* 如果查出的password 和 用户传入的不一致则会
		* 抛出异常
		* */
		Object password = authenticationToken.getCredentials();
		
		
		/*
		*
		* 这里采用采用了MD5认证的方式
		*
		* userName 为 用户名
		*
		* c27a952f91997b8f16e89482ed226a5a 为加密后的密码
		*
		* ByteSource.Util.bytes("aaaaa")加入盐的byte数组
		*
		* getName() realm 的名字
		* */
		
		
		
		return new SimpleAuthenticationInfo(userName,"c27a952f91997b8f16e89482ed226a5a", ByteSource.Util.bytes("aaaaa"),getName());
	}
}
