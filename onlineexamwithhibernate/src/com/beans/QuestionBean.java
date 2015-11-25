package com.beans;

import java.util.Map;

public class QuestionBean
{
    private Integer questionId;
    private String question;
    private Map<Integer, String> answerChoices;

    public Integer getQuestionId()
    {
        return questionId;
    }

    public void setQuestionId(Integer questionId)
    {
        this.questionId = questionId;
    }

    public String getQuestion()
    {
        return question;
    }

    public void setQuestion(String question)
    {
        this.question = question;
    }

    public Map<Integer, String> getAnswerChoices()
    {
        return answerChoices;
    }

    public void setAnswerChoices(Map<Integer, String> answerChoices)
    {
        this.answerChoices = answerChoices;
    }

}
