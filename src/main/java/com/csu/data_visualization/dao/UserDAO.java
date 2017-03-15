package com.csu.data_visualization.dao;

import com.csu.data_visualization.model.user;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

/**
 * Created by ZhangRui on 2017/3/10.
 */
@Repository
public class UserDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public List<user> getUsers() {
        String tableName="user";
        String hql = " FROM " + tableName;
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        return query.list();
    }
}
