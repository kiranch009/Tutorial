package com.servlets;

import com.beans.User;
import com.service.impl.LoginServiceImpl;

public class Client
{
    public static void main(String[] args)
    {
        User user = new LoginServiceImpl().getUser("admin", "admin");
        System.out.println(user.getUserId());
    }
}
