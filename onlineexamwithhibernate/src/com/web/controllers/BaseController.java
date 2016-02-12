package com.web.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

public class BaseController
{
    @ExceptionHandler
    public ModelAndView handleException(HttpServletRequest request, Exception exception)
    {
        ModelAndView modelAndView = new ModelAndView("error_view");
        request.setAttribute("exceptionMsg", exception.getMessage());
        return modelAndView;
    }
}
