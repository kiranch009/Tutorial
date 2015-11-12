package com.service.impl;

import com.beans.User;
import com.dao.UserDAO;
import com.dao.impl.UserDAOImpl;
import com.services.LoginService;

public class LoginServiceImpl implements LoginService
{
    private UserDAO userDao;

    public LoginServiceImpl()
    {
        userDao = new UserDAOImpl();
    }
    public User getUser(String userName, String password)
    {
        return userDao.getUser(userName, password);
    }
}
