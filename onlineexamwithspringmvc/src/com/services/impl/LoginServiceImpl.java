package com.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beans.User;
import com.dao.UserDao;
import com.services.LoginService;
@Service
public class LoginServiceImpl implements LoginService
{
	@Autowired
    private UserDao userDao;
    
    public User getUser(String userName, String password)
    {
        return userDao.getUser(userName, password);
    }
}
