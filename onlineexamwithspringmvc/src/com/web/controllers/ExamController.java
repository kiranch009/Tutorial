package com.web.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.beans.ExamQuestion;
import com.beans.Technology;
import com.services.ExamService;

@Controller
public class ExamController extends BaseController{
	
	@Autowired
	private ExamService examService;
	
	@RequestMapping(value = "/selectTechnology", method = RequestMethod.GET)
	public ModelAndView getTechnologies()
	{
		List<Technology> technologyList=examService.getAvailableTechnologies();
		Map<Integer,String> technologyMap=new HashMap<Integer,String>();
		for(Technology technology:technologyList)
		{
			technologyMap.put(technology.getTechnologyId(),technology.getTechnologyName());
		}
		
		ModelAndView modelAndView=new ModelAndView("selecttechnology_view");
		modelAndView.addObject("technologies",technologyMap);
		modelAndView.addObject("technology","asdfasf");
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/startExam", method = RequestMethod.POST)
	public ModelAndView getQuestions(@RequestParam Integer technology)
	{
		List<ExamQuestion> questions=examService.getQuestions(technology);
		ModelAndView modelAndView=new ModelAndView("startexam_view");
		modelAndView.addObject(questions);
		return modelAndView;
	}
}
