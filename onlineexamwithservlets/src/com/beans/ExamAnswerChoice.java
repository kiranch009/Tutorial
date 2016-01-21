package com.beans;

public class ExamAnswerChoice implements java.io.Serializable
{

    private Integer choiceId;
    private ExamQuestion examQuestion;
    private String answerChoice;


    public Integer getChoiceId()
    {
        return this.choiceId;
    }

    public void setChoiceId(Integer choiceId)
    {
        this.choiceId = choiceId;
    }

    public ExamQuestion getExamQuestion()
    {
        return examQuestion;
    }

    public void setExamQuestion(ExamQuestion examQuestion)
    {
        this.examQuestion = examQuestion;
    }

    public String getAnswerChoice()
    {
        return this.answerChoice;
    }

    public void setAnswerChoice(String answerChoice)
    {
        this.answerChoice = answerChoice;
    }

}
