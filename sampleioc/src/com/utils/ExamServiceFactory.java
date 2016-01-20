package com.utils;

import com.service.ExamService;
import com.service.impl.ExamServiceImpl;

public class ExamServiceFactory {
	public static ExamService getExamService()
	{
		
		return new ExamServiceImpl();
	}
}
