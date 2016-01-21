package com.services.impl;

import java.util.List;

import com.beans.User;
import com.beans.UserAddress;
import com.dao.UserDao;
import com.dao.impl.UserDAOImpl;
import com.services.UserService;

public class UserServiceImpl implements UserService
{

    private UserDao userDao;
    
    public UserServiceImpl()
    {
    	userDao=new UserDAOImpl();
    }

    @Override
    public Integer saveUserAddress(UserAddress userAddress)
    {
        return userDao.saveUserAddress(userAddress);
    }

    @Override
    public UserAddress getUserAddress(Integer addressId)
    {
        return userDao.getUserAddress(addressId);
    }

    @Override
    public void saveUser(User user)
    {
        userDao.saveUser(user);

    }

    @Override
    public List<User> getUser(String userName, String password)
    {
        return userDao.getUser(userName, password);
    }

}
