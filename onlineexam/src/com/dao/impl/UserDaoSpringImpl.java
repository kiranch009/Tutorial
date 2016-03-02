package com.dao.impl;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.beans.User;
import com.beans.UserAddress;
import com.dao.UserDao;

@Repository("userDao")
public class UserDaoSpringImpl extends BaseDao implements UserDao {

	@Override
	public User getUser(String userName, String password) {
		
		String query = "SELECT u from User u WHERE u.loginId=? and u.loginPassword=?";
		
		@SuppressWarnings("unchecked")
		List<User> list = (List<User>) getHibernateTemplate().find(query,
				userName, password);
		for (User user : list) {
			System.out
					.println(user.getUserAddressByMailingAddress().getState());
			System.out.println(user.getUserAddressByPermanentAddress()
					.getState());
		}
		if (CollectionUtils.isEmpty(list)) {
			return null;
		} else {
			return list.get(0);
		}
	}

	@Override
	public void saveUser(User user) {
		getHibernateTemplate().save(user);

	}

	@Override
	public Integer saveUserAddress(UserAddress userAddress) {
		Integer addressId = (Integer) getHibernateTemplate().save(userAddress);
		return addressId;
	}

	@Override
	public UserAddress getUserAddress(Integer addressId) {

		UserAddress userAddress = getHibernateTemplate().get(UserAddress.class,
				addressId);
		userAddress.getUsers();
		return userAddress;
	}

	@Override
	public void updateUser(User user) {

		getHibernateTemplate().update(user);
	}

}
