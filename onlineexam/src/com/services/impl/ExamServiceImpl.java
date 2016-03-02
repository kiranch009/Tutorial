package com.services.impl;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.beans.ExamQuestion;
import com.beans.Technology;
import com.dao.ExamDao;
import com.services.ExamService;
@Service
@Transactional
public class ExamServiceImpl implements ExamService
{
	@Autowired
    private ExamDao examDao;
    

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
