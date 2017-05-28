package com.alex.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;

/**
 * Created by Alex on 2017/5/26.
 *
 * shiro 入门的第4个例子
 *
 * shiro授权的入门
 *
 */
@SuppressWarnings("all")
public class ShiroDemo4 {
	
	public static void main(String[] args) {
		
		
		//构建securityManagerFactory 工厂类
		
		IniSecurityManagerFactory securityManagerFactory = new IniSecurityManagerFactory("classpath:shiro-four.ini");
		
		//创建securityManager
		SecurityManager securityManager = securityManagerFactory.getInstance();
		
		//配置shiro的运行环境
		SecurityUtils.setSecurityManager(securityManager);
		
		//创建subject
		Subject subject = SecurityUtils.getSubject();
		
		//创建token
		UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("wang", "123");
		
		//登录 提交认证
		try {
			//如果认证通过就不会抛出异常
			subject.login(usernamePasswordToken);
		} catch (AuthenticationException e) {
			e.printStackTrace();
		}
		//输出是否认证通过
		System.out.println("认证通过"+subject.isAuthenticated());
		
		System.out.println("是否含有角色role2:"+subject.hasRole("role2"));
		System.out.println("是否含有角色role5:"+subject.hasRole("role5"));
		
		
	}

}
