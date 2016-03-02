package com.restcontrollers;

import javax.servlet.http.HttpServletRequest;

import org.dozer.DozerBeanMapper;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dto.ErrorDto;

public class BaseController
{

    protected DozerBeanMapper mapper;

    @ExceptionHandler
    public ErrorDto handleException(HttpServletRequest request, Exception exception)
    {
        ErrorDto dto = new ErrorDto();
        dto.setMessage("Error in process:" + exception.getMessage());
        return dto;
    }
}
