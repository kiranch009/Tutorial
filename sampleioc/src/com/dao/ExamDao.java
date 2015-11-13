package com.dao;

import java.util.List;
import java.util.Map;

public interface ExamDao {
	public List<String> geteTechnologyList();
	public Map<String,List<Object>> getQuestions(String technologyId);
}
