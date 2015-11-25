package com.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.beans.UserAddress;
import com.dao.UserDao;
import com.services.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService
{

    @Autowired
    private UserDao userDao;

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

}
