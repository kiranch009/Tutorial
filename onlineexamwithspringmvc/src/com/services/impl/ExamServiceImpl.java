package com.services.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beans.QuestionBean;
import com.dao.ExamDAO;
import com.services.ExamService;

@Service
public class ExamServiceImpl implements ExamService
{
    @Autowired
    private ExamDAO examDao;

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
