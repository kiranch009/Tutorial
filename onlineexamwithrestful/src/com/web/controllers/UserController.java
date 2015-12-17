package com.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.beans.User;
import com.dto.UserDto;
import com.services.UserService;
import com.web.validators.UserValidator;

@RestController
public class UserController extends BaseController
{
    @Autowired
    private UserValidator userValidator;

    @Autowired
    private UserService userService;

    //    @RequestMapping(value = "/register", method = RequestMethod.GET)
    //    public ModelAndView getRegistrationForm()
    //    {
    //        ModelAndView modelAndView = new ModelAndView("user_view");
    //        modelAndView.addObject("user", new UserDto());
    //        modelAndView.addObject("disableUserId", true);
    //        return modelAndView;
    //    }

    @RequestMapping(value = "/register", method = RequestMethod.GET,
            produces = { "application/json", "application/xml" })
    @ResponseBody
    public UserDto getRegistrationForm()
    {
        UserDto dto = new UserDto();
        dto.setUserName("name");
        return dto;
    }

    //    @RequestMapping(value = "/register", method = RequestMethod.POST)
    //    public ModelAndView saveuser(HttpServletRequest request, @ModelAttribute UserDto userDto, Errors errors)
    //    {
    //        User user = getUser(userDto);
    //        userValidator.validate(user, errors);
    //        if (errors.hasErrors())
    //        {
    //            return new ModelAndView("user_view");
    //        }
    //        //Exception handling example
    //        if (user.getUserName().equals("error"))
    //        {
    //            throw new RuntimeException("Error in save");
    //        }
    //        System.out.println(user.getUserName());
    //        System.out.println(user.getLoginId());
    //        //        System.out.println(user.getDob());
    //        System.out.println(user.getQualification());
    //        System.out.println(user.getEmailId());
    //        System.out.println(user.getMobile());
    //        //        request.getSession().setAttribute("USER", user);
    //
    //        userService.saveUser(user);
    //        return new ModelAndView("home_view");
    //    }

    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = "application/json",
            consumes = "application/json")
    @ResponseBody
    public String saveuser(@RequestBody UserDto userDto)
    {
        User user = getUser(userDto);
        //Exception handling example
        if (user.getUserName().equals("error"))
        {
            throw new RuntimeException("Error in save");
        }
        System.out.println(user.getUserName());
        System.out.println(user.getLoginId());
        //        System.out.println(user.getDob());
        System.out.println(user.getQualification());
        System.out.println(user.getEmailId());
        System.out.println(user.getMobile());
        //        request.getSession().setAttribute("USER", user);

        userService.saveUser(user);
        String status = "SUCCESS";
        return status;
    }

    //    @InitBinder
    //    public void initBinder(WebDataBinder binder)
    //    {
    //        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    //        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    //    }

    //    @RequestMapping(value = "/updateUser", method = RequestMethod.GET)
    //    public ModelAndView loadUserInfo(HttpServletRequest request)
    //    {
    //
    //        User user = (User) request.getSession().getAttribute("USER");
    //
    //        ModelAndView modelAndView = new ModelAndView("user_view");
    //        modelAndView.addObject("user", getUserDto(user));
    //        modelAndView.addObject("disableUserId", true);
    //        return modelAndView;
    //
    //    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.GET)
    public UserDto loadUserInfo()
    {
        User user = new User();

        return getUserDto(user);

    }

    private UserDto getUserDto(User user)
    {
        return mapper.map(user, UserDto.class);
    }

    private User getUser(UserDto userDto)
    {
        return mapper.map(userDto, User.class);
    }
}
