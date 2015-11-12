package com.service.impl;

import java.util.List;
import java.util.Map;

import com.beans.QuestionBean;
import com.dao.ExamDAO;
import com.dao.impl.ExamDAOImpl;
import com.services.ExamService;

public class ExamServiceImpl implements ExamService
{

    private ExamDAO examDao;

    public ExamServiceImpl()
    {
        examDao = new ExamDAOImpl();
    }
    @Override
    public Map<Integer, String> getAvailableTechnologies()
    {
        return examDao.getAvailableTechnologies();
    }

    public List<QuestionBean> getQuestions(Integer technologyId)
    {
        return examDao.getQuestions(technologyId);
    }

}
