package com.beans;


import java.util.HashSet;
import java.util.Set;
public class Technology implements java.io.Serializable
{

    private Integer technologyId;
    private String technologyName;
    private Set<ExamQuestion> examQuestions = new HashSet<ExamQuestion>(0);


    public Integer getTechnologyId()
    {
        return this.technologyId;
    }

    public void setTechnologyId(Integer technologyId)
    {
        this.technologyId = technologyId;
    }

    public String getTechnologyName()
    {
        return this.technologyName;
    }

    public void setTechnologyName(String technologyName)
    {
        this.technologyName = technologyName;
    }

    public Set<ExamQuestion> getExamQuestions()
    {
        return this.examQuestions;
    }

    public void setExamQuestions(Set<ExamQuestion> examQuestionses)
    {
        this.examQuestions = examQuestionses;
    }

}
