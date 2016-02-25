package com.beans;

/**Bean to hold exam answer details*/
public class ExamAnswer implements java.io.Serializable
{

    private Integer answerId;
    private int questionId;
    private int choiceId;

    public Integer getAnswerId()
    {
        return this.answerId;
    }

    public void setAnswerId(Integer answerId)
    {
        this.answerId = answerId;
    }

    public int getQuestionId()
    {
        return this.questionId;
    }

    public void setQuestionId(int questionId)
    {
        this.questionId = questionId;
    }

    public int getChoiceId()
    {
        return this.choiceId;
    }

    public void setChoiceId(int choiceId)
    {
        this.choiceId = choiceId;
    }

}
