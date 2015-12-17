package com.services;

import java.util.List;

import com.beans.User;

public interface LoginService
{
    public List<User> getUser(String userName, String password);
}
