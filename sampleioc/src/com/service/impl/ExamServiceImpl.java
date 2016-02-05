package com.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.dao.ExamDao;
import com.service.ExamService;
@Service
@Scope(scopeName="",value="")
public class ExamServiceImpl implements ExamService {
	@Autowired
	private ExamDao examDao;
	
	private String type;
	private String name;
	
	public ExamServiceImpl()
	{
		this.name=this.name.concat("my text");
	}
	
	@Override
	public Map<String, List<Object>> getQuestions(String technologyId) {
		return examDao.getQuestions(technologyId);
	}
	



}
