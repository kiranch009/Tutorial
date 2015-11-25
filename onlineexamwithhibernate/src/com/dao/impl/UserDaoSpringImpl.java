package com.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.beans.User;
import com.beans.UserAddress;
import com.dao.UserDao;

@Repository("userDao")
public class UserDaoSpringImpl extends BaseDao implements UserDao
{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User getUser(String userName, String password)
    {
        return null;
    }

    @Override
    public void saveUser(User user)
    {
        System.out.println(user);

    }

    //    @Transactional(value=)
    @Override
    public Integer saveUserAddress(UserAddress userAddress)
    {
        Integer addressId = (Integer) getHibernateTemplate().save(userAddress);
        return addressId;
    }

    @Override
    public UserAddress getUserAddress(Integer addressId)
    {
        UserAddress userAddress = getHibernateTemplate().get(UserAddress.class, addressId);
        return userAddress;
    }

}
