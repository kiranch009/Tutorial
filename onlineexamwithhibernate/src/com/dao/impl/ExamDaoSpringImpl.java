package com.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.beans.QuestionBean;
import com.dao.ExamDao;

@Repository("examDao")
public class ExamDaoSpringImpl extends BaseDao implements ExamDao
{
    @Override
    public Map<Integer, String> getAvailableTechnologies()
    {
        return null;
    }

    @Override
    public List<QuestionBean> getQuestions(Integer technologyId)
    {
        return null;
    }

}
