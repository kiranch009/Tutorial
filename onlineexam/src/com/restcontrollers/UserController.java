package com.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.beans.User;
import com.dto.UserDto;
import com.services.UserService;

@RestController
public class UserController extends BaseController
{
    @Autowired
    private UserService userService;

    public UserController()
    {
        System.out.println("");
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = { "application/json" },
            consumes = "application/json")
    @ResponseBody
    public UserDto authenticateUser(@RequestBody UserDto userDto)
    {
        User user = userService.getUser(userDto.getUserName(), userDto.getPassword());
        if (user != null)
        {
            return getUserDto(user);
        } else
        {
            throw new RuntimeException("Invalid credentials");
        }

    }

    @RequestMapping(value = "/register", method = RequestMethod.GET, produces = { "application/json" })
    @ResponseBody
    public UserDto getRegistrationForm()
    {
        UserDto dto = new UserDto();
        dto.setUserName("name");
        return dto;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = "application/json",
            consumes = "application/json")
    @ResponseBody
    public String saveuser(@RequestBody UserDto userDto)
    {
        User user = getUser(userDto);
        // Exception handling example
        if (user.getUserName().equals("error"))
        {
            throw new RuntimeException("Error in save");
        }
        System.out.println(user.getUserName());
        System.out.println(user.getLoginId());
        // System.out.println(user.getDob());
        System.out.println(user.getQualification());
        System.out.println(user.getEmailId());
        System.out.println(user.getMobile());
        // request.getSession().setAttribute("USER", user);

        userService.saveUser(user);
        String status = "SUCCESS";
        return status;
    }

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
