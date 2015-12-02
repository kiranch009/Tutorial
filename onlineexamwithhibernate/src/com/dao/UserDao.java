package com.dao;

import java.util.List;

import com.beans.User;
import com.beans.UserAddress;

public interface UserDao
{
    public List<User> getUser(String userName, String password);

    public void saveUser(User user);

    public Integer saveUserAddress(UserAddress userAddress);

    public UserAddress getUserAddress(Integer addressId);
}
