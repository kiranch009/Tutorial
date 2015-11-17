package com.dao;

import com.beans.User;

public interface UserDAO
{
    public User getUser(String userName, String password);
}
