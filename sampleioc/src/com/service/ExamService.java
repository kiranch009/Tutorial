package com.service;

import java.util.List;
import java.util.Map;

public interface ExamService {
	public Map<String,List<Object>> getQuestions(String technologyId);
}
