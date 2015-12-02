package com.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.beans.ExamQuestion;
import com.beans.Technology;
import com.services.ExamService;

@ContextConfiguration("classpath:spring-core-config.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ExamServiceTest
{
    @Autowired
    private ExamService examService;

    //    @Test
    public void getQuestionsTest()
    {
        List<ExamQuestion> list = examService.getQuestions(2);
        System.out.println("Questions size:" + list.size());
    }

    @Test
    public void getAvailableTechnologiesTest()
    {
        List<Technology> list = examService.getAvailableTechnologies();
        System.out.println("Technologies size:" + list.size());
    }

}
