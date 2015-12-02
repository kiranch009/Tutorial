package com.services;

import java.util.List;

import com.beans.ExamQuestion;
import com.beans.Technology;

public interface ExamService
{
    public List<Technology> getAvailableTechnologies();

    public List<ExamQuestion> getQuestions(Integer technologyId);
}
