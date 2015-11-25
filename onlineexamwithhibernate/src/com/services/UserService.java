package com.services;

import com.beans.UserAddress;

public interface UserService
{
    public Integer saveUserAddress(UserAddress userAddress);

    public UserAddress getUserAddress(Integer addressId);
}
