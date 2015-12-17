package com.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

public abstract class BaseDao extends HibernateDaoSupport
{
    @Autowired
    public void setFactory(SessionFactory sessionFactory)
    {
        setSessionFactory(sessionFactory);
    }
}
