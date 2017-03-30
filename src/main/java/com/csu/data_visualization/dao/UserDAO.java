package com.csu.data_visualization.dao;

import com.csu.data_visualization.model.user;
import com.csu.data_visualization.service.dataRecordService;
import org.apache.log4j.Logger;
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

    private static final Logger logger=Logger.getLogger(UserDAO.class);

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * 获取所有用户
     * @return list<user>
     */
    public List<user> getUsers() {
        logger.info("进入getUsers函数");

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
        logger.info("进入getUserByAccount函数"+" 参数:"+" loginAccount-"+loginAccount);

        String tableName = "user";
        String account="account";
        String hql = " FROM " +tableName + " WHERE " + account + " = :account";
        Query query=sessionFactory.getCurrentSession().createQuery(hql);
        query.setString("account",loginAccount);
        return (user)query.uniqueResult();
    }

}
