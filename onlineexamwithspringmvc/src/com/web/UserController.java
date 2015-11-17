package com.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.beans.User;

@Controller
public class UserController
{
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView getRegistrationForm()
    {
        ModelAndView modelAndView = new ModelAndView("user_view");
        modelAndView.addObject("user", new User());
        modelAndView.addObject("disableUserId", true);
        return modelAndView;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView saveuser(HttpServletRequest request, @ModelAttribute User user)
    {
        System.out.println(user.getUserName());
        System.out.println(user.getLoginId());
        System.out.println(user.getDob());
        System.out.println(user.getQualification());
        System.out.println(user.getEmailId());
        System.out.println(user.getMobile());
        request.getSession().setAttribute("USER", user);
        return new ModelAndView("home_view");
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
