package com.web.validators;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.beans.User;

@Component
public class UserValidator implements Validator
{

    @Override
    public boolean supports(Class<?> cls)
    {
        return User.class.equals(cls);
    }

    @Override
    public void validate(Object obj, Errors errors)
    {
        User user = (User) obj;
        if (StringUtils.isEmpty(user.getUserName()))
        {
            errors.rejectValue("userName", "required");
        }

    }

}
