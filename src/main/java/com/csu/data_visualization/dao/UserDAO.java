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
public class UserDAO extends DAOSupport {
    @Autowired
    private SessionFactory sessionFactory;

    /**
     * 获取所有用户
     * @return list<user>
     */
    public List<user> getUsers() {
        String tableName="user";
        String hql = " FROM " + tableName;
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        return query.list();
    }

    /**
     * 根据账户获取用户
     * @param loginAccount
     * @return user
     */
    public user getUserByAccount(String loginAccount) {
        String tableName = "user";
        String account="account";
        String hql = " FROM " +tableName + " WHERE " + account + " = :account";
        Query query=sessionFactory.getCurrentSession().createQuery(hql);
        query.setString("account",loginAccount);
        return (user)query.uniqueResult();
    }

}
