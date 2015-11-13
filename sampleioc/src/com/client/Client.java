package com.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.service.ExamService;
import com.service.TechnologyService;

public class Client {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationcontext.xml");
		
		
		
		
		TechnologyService techService=context.getBean("technologyService",TechnologyService.class);
		System.out.println(techService.getTechnologyList());
		
		ExamService service=context.getBean("examService",ExamService.class);
		System.out.println(service.getQuestions("1"));
	}

}
