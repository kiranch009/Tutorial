package com.service.impl;

import java.util.List;

import com.dao.ExamDao;
import com.service.TechnologyService;

public class TechnologyServiceImpl implements TechnologyService{
	public ExamDao examDao;
	
	
	@Override
	public List<String> getTechnologyList() {
		return examDao.geteTechnologyList();
	}


	public ExamDao getExamDao() {
		return examDao;
	}


	public void setExamDao(ExamDao examDao) {
		this.examDao = examDao;
	}
	
	

}
