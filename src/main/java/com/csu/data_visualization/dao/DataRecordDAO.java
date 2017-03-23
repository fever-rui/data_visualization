package com.csu.data_visualization.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by ZhangRui on 2017/3/23.
 */
@Repository
public class DataRecordDAO extends DAOSupport {
    @Autowired
    private SessionFactory sessionFactory;
}
