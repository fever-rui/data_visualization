package com.csu.data_visualization.dao;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

/**
 * Created by ZhangRui on 2017/3/17.
 */
public class DAOSupport<T> extends HibernateDaoSupport {

    @Autowired
    public void putSessionFactory(SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }

    public boolean saveOrUpdate(T t) {
        getHibernateTemplate().saveOrUpdate(t);
        System.out.println("存储中");
        return true;
    }

    public boolean save(T t) {
        getHibernateTemplate().save(t);
        return true;
    }

    public boolean Update(T t) {

        getHibernateTemplate().update(t);
        return true;
    }
}
