package com.services;

import com.beans.User;
import com.beans.UserAddress;

public interface UserService {
	public Integer saveUserAddress(UserAddress userAddress);

	public UserAddress getUserAddress(Integer addressId);

	public void saveUser(User user);

	public void updateUser(User user);

	public User getUser(String userName, String password);
}
