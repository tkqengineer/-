package com.alex.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Alex on 2016/12/21.
 */
public class HibernateUtils {
	
	private static  SessionFactory sessionFactory;
	
	static {
		
		Configuration configuration=new Configuration();
		configuration.configure("hibernate.cfg.xml");
		 sessionFactory = configuration.buildSessionFactory();
	}
	
	public static Session getSession(){
		
		return sessionFactory.openSession();
		
	}
	
	
}
