package com.beans;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ExamQuestion implements java.io.Serializable
{

    private Integer questionId;
    private Technology technology;
    private String question;
    private List<ExamAnswerChoice> examAnswerChoices;

    public Integer getQuestionId()
    {
        return this.questionId;
    }

    public void setQuestionId(Integer questionId)
    {
        this.questionId = questionId;
    }

    public Technology getTechnology()
    {
        return this.technology;
    }

    public void setTechnology(Technology technology)
    {
        this.technology = technology;
    }

    public String getQuestion()
    {
        return this.question;
    }

    public void setQuestion(String question)
    {
        this.question = question;
    }

	public List<ExamAnswerChoice> getExamAnswerChoices() {
		return examAnswerChoices;
	}

	public void setExamAnswerChoices(List<ExamAnswerChoice> examAnswerChoices) {
		this.examAnswerChoices = examAnswerChoices;
	}

    

}
