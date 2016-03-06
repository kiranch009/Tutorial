package com.restcontrollers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.beans.Technology;
import com.dto.TechnologyDto;
import com.services.ExamService;

@RestController
public class ExamResources extends BaseController
{
    @Autowired
    private ExamService examService;

    @RequestMapping(value = "/selectTechnology", method = RequestMethod.GET, produces = "application/json")
    public List<TechnologyDto> getTechnologies()
    {
        List<Technology> technologyList = examService.getAvailableTechnologies();
        return getTechnologyDtos(technologyList);

    }

    //    @RequestMapping(value = "/startExam", method = RequestMethod.POST)
    //    public ModelAndView getQuestions(@RequestParam Integer technology)
    //    {
    //        List<ExamQuestion> questions=examService.getQuestions(technology);
    //        ModelAndView modelAndView=new ModelAndView("startexam_view");
    //        modelAndView.addObject(questions);
    //        return modelAndView;
    //    }
    private List<TechnologyDto> getTechnologyDtos(List<Technology> technologyList)
    {
        List<TechnologyDto> dtoList = new ArrayList<TechnologyDto>();
        for (Technology technology : technologyList)
        {
            dtoList.add(getTechnologyDto(technology));
        }
        return dtoList;
    }

    private TechnologyDto getTechnologyDto(Technology technology)
    {
        return mapper.map(technology, TechnologyDto.class);
    }
}
