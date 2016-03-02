package com.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.beans.ExamQuestion;
import com.beans.Technology;
import com.dao.ExamDao;

@Repository("examDao")
public class ExamDaoSpringImpl extends BaseDao implements ExamDao
{
    @Override
    public List<Technology> getAvailableTechnologies()
    {
        List<Technology> list = getHibernateTemplate().loadAll(Technology.class);
        System.out.println("Technologies size:" + list.size());
        for (Technology technology : list)
        {
            System.out.println("No.of questions in " + technology.getTechnologyName() + ":" +
                               technology.getExamQuestions().size());
        }
        return list;
    }

    @Override
    public List<ExamQuestion> getQuestions(Integer technologyId)
    {
        String query = "Select q from ExamQuestion q where q.technology.technologyId=?";
        @SuppressWarnings("unchecked")
        List<ExamQuestion> list = (List<ExamQuestion>) getHibernateTemplate().find(query, technologyId);

        for (ExamQuestion question : list)
        {
            System.out.println("number of choices to :" + question.getQuestionId() + " are: " +
                               question.getExamAnswerChoices().size());
        }
        return list;
    }

}
