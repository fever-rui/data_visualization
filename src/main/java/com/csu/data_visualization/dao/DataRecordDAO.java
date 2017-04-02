package com.csu.data_visualization.dao;

import com.csu.data_visualization.model.Page;
import com.csu.data_visualization.model.data_record;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * Created by ZhangRui on 2017/3/23.
 */
@Repository
public class DataRecordDAO extends DAOSupport {

    private static final Logger logger=Logger.getLogger(DataRecordDAO.class);

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * 根据uid查询记录，时间逆序排列
     * @param id
     * @return
     */
    public List<data_record> getRecordByUid(Integer id) {
        logger.info("进入getRecordByUid函数"+" 参数:"+" id-"+id);

        String tableName="data_record";
        String sort="create_time";
        String uid="uid";
        String hql = " FROM " +tableName + " WHERE " + uid + " = :uid" + " ORDER BY "+sort+" DESC";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setInteger("uid",id);
        return query.list();
    }

    public List<data_record> getAllRecordByUid(Integer id,final Page page) {
        logger.info("进入getAllRecordByUid函数"+" 参数:"+" id-"+id+" page:"+ page);

        String tableName="data_record";
        String sort="create_time";
        String uid="uid";
        String hql = " FROM " +tableName + " WHERE " + uid + " = :uid" + " ORDER BY "+sort+" DESC";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);//执行查询操作
        query.setInteger("uid",id);
        //设置每页显示多少个，设置多大结果。
        query.setMaxResults(page.getEveryPage());
        //设置起点
        query.setFirstResult(page.getBeginIndex());
        return query.list();
    }

    public Integer getRecordSize(Integer id) {
        logger.info("进入getRecordSize函数"+" 参数:"+" id-"+id);

        String tableName="data_record";
        String uid="uid";
        String hql = " FROM " +tableName + " WHERE " + uid + " = :uid";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);//执行查询操作
        query.setInteger("uid",id);
        return query.list().size();
    }
}
