package com.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.service.ExamService;
import com.service.TechnologyService;
import com.service.impl.TechnologyServiceImpl;
import com.utils.ContextFactory;

public class Client {
	public static void main(String[] args) {
		
//		ApplicationContext context=null;
//		if(Messages.getProperty("DB").equals("Mysql"))
//		{
//			context=new ClassPathXmlApplicationContext("applicationcontext.xml");
//		}else{
//			context=new ClassPathXmlApplicationContext("applicationcontext_mysql.xml");
//		}
		
		
		
		TechnologyService techService=ContextFactory.getBean("technologyService",TechnologyService.class);
		System.out.println(techService.getTechnologyList());
		
		ExamService service=ContextFactory.getBean("examService",ExamService.class);
		System.out.println(service.getQuestions("1"));
	}

}
