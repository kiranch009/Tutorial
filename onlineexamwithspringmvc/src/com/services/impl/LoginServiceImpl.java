package com.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beans.User;
import com.dao.UserDAO;
import com.services.LoginService;

@Service
public class LoginServiceImpl implements LoginService
{
    @Autowired
    private UserDAO userDao;

    public User getUser(String userName, String password)
    {
        return userDao.getUser(userName, password);
    }
}
