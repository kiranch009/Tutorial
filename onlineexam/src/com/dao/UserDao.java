package com.dao;

import java.util.List;

import com.beans.User;
import com.beans.UserAddress;

public interface UserDao
{
    public User getUser(String userName, String password);

    public void saveUser(User user);
    
    public void updateUser(User user);

    public Integer saveUserAddress(UserAddress userAddress);

    public UserAddress getUserAddress(Integer addressId);
}
