package com.web.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.beans.User;
import com.services.UserService;
import com.web.validators.UserValidator;

@Controller
public class UserController extends BaseController
{
    @Autowired
    private UserValidator userValidator;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView getRegistrationForm()
    {
        ModelAndView modelAndView = new ModelAndView("user_view");
        modelAndView.addObject("user", new User());
        modelAndView.addObject("disableUserId", true);
        return modelAndView;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView saveuser(HttpServletRequest request, @ModelAttribute User user, Errors errors)
    {
        userValidator.validate(user, errors);
        if (errors.hasErrors())
        {
            return new ModelAndView("user_view");
        }
        //Exception handling example
        if (user.getUserName().equals("error"))
        {
            throw new RuntimeException("Error in save");
        }
        System.out.println(user.getUserName());
        System.out.println(user.getLoginId());
        System.out.println(user.getDob());
        System.out.println(user.getQualification());
        System.out.println(user.getEmailId());
        System.out.println(user.getMobile());
        if(user.getUserId()==null)
        {
        	userService.saveUser(user);
        }else{
        	userService.updateUser(user);
        }
        request.getSession().setAttribute("USER", user);
        return new ModelAndView("home_view");
    }

    @InitBinder
    public void initBinder(WebDataBinder binder)
    {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.GET)
    public ModelAndView loadUserInfo(HttpServletRequest request)
    {

        User user = (User) request.getSession().getAttribute("USER");

        ModelAndView modelAndView = new ModelAndView("user_view");
        modelAndView.addObject("user", user);
        modelAndView.addObject("disableUserId", true);
        return modelAndView;

    }
}
