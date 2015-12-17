package com.web.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.beans.User;
import com.services.LoginService;

@Controller
public class LoginController extends BaseController
{

    @Autowired
    private LoginService loginService;

    @Value("${login.failed}")
    private String loginFailedmsg;

    @Autowired
    private Environment env;

    @RequestMapping(value = "/home", method = RequestMethod.POST)
    public ModelAndView authenticateUser(HttpServletRequest request, @RequestParam String userName,
            @RequestParam String password)
    {
        ModelAndView modelAndView = null;
        env.getProperty("login.failed");

        User user = null;
        //                loginService.getUser(userName, password);
        if (user != null)
        {
            modelAndView = new ModelAndView("home_view");
        } else
        {
            modelAndView = new ModelAndView("index_view");
            request.setAttribute("loginError", loginFailedmsg);
        }
        return modelAndView;
    }
}
