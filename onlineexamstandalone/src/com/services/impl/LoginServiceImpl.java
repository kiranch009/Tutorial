package com.services.impl;

import java.util.List;

import com.beans.User;
import com.dao.UserDao;
import com.dao.impl.UserDAOImpl;
import com.services.LoginService;

public class LoginServiceImpl implements LoginService
{
    private UserDao userDao;
    
    public LoginServiceImpl()
    {
    	userDao=new UserDAOImpl();
    }

    public List<User> getUser(String userName, String password)
    {
        return userDao.getUser(userName, password);
    }
}
