package com.services;

import com.beans.User;

public interface LoginService
{
    public User getUser(String userName, String password);
}
