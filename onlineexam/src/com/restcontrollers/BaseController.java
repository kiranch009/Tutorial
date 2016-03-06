package com.restcontrollers;

import javax.servlet.http.HttpServletRequest;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.dto.ErrorDto;

public class BaseController
{
    @Autowired
    protected DozerBeanMapper mapper;

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler
    public ErrorDto handleException(HttpServletRequest request, Exception exception)
    {
        ErrorDto dto = new ErrorDto();
        dto.setMessage("Error in process:" + exception.getMessage());
        return dto;
    }
}
