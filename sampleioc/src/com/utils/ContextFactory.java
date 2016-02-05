package com.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContextFactory {
	private static ApplicationContext context=new ClassPathXmlApplicationContext("applicationcontext.xml");
	
	public static <T> T getBean(String beanId,Class<T> beanType)
	{
		return context.getBean(beanId,beanType);
	}
	
}
