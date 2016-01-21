package com.services.impl;

import java.util.List;

import com.beans.ExamQuestion;
import com.beans.Technology;
import com.dao.ExamDao;
import com.dao.impl.ExamDAOImpl;
import com.services.ExamService;

public class ExamServiceImpl implements ExamService
{
    private ExamDao examDao;
    
    public ExamServiceImpl()
    {
    	examDao=new ExamDAOImpl();
    }

    @Override
    public List<Technology> getAvailableTechnologies()
    {
        return examDao.getAvailableTechnologies();
    }

    public List<ExamQuestion> getQuestions(Integer technologyId)
    {
        return examDao.getQuestions(technologyId);
    }

}
