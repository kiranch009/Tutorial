package com.dao;

import java.util.List;

import com.beans.ExamQuestion;
import com.beans.Technology;

public interface ExamDao
{
    public List<Technology> getAvailableTechnologies();

    public List<ExamQuestion> getQuestions(Integer technologyId);
}
