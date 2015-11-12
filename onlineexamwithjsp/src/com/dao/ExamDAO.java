package com.dao;

import java.util.List;
import java.util.Map;

import com.beans.QuestionBean;

public interface ExamDAO
{
    public Map<Integer, String> getAvailableTechnologies();

    public List<QuestionBean> getQuestions(Integer technologyId);
}
