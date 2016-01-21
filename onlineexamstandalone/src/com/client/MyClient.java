package com.client;

import java.util.List;

import com.beans.ExamAnswerChoice;
import com.beans.ExamQuestion;
import com.services.ExamService;
import com.services.impl.ExamServiceImpl;

public class MyClient {
	public static void main(String[] args) {
		ExamService examService=new ExamServiceImpl();
		List<ExamQuestion> questions=examService.getQuestions(2);
		for(int i=0;i<questions.size();i++)
		{
			ExamQuestion question=questions.get(0);
			System.out.println((i+1)+".\t"+question.getQuestion());
			
			for(int j=0; j<question.getExamAnswerChoices().size();j++)
			{
				ExamAnswerChoice choice=question.getExamAnswerChoices().get(j);
				
				System.out.println("\t"+(j+1)+".\t"+choice.getAnswerChoice());
			}
		}
		
	}
}
