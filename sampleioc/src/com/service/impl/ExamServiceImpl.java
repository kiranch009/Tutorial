package com.service.impl;

import java.util.List;
import java.util.Map;

import com.dao.ExamDao;
import com.service.ExamService;

public class ExamServiceImpl implements ExamService {
	private ExamDao examDao;
	
	@Override
	public Map<String, List<Object>> getQuestions(String technologyId) {
		return examDao.getQuestions(technologyId);
	}
	public ExamDao getExamDao() {
		return examDao;
	}
	public void setExamDao(ExamDao examDao) {
		this.examDao = examDao;
	}



}
