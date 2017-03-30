package com.csu.data_visualization.service;

import com.csu.data_visualization.dao.UserDAO;
import com.csu.data_visualization.model.user;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ZhangRui on 2017/3/10.
 */
@Service("userService")
@Transactional
public class userService {

    private static final Logger logger=Logger.getLogger(userService.class);

    @Autowired
    private UserDAO userDAO;

    /**
     * 获取所有用户
     * @return
     */
    public List<user> getUsers() {
        logger.info("进入getUsers函数");

        return userDAO.getUsers();
    }

    /**
     * 根据账号获取用户
     * @param account
     * @return
     */
    public user getUserByAccount(String account) {
        logger.info("进入getUsersByAccount函数"+" 参数:"+" account-"+account);

        return userDAO.getUserByAccount(account);
    }

    /**
     * 注册新用户
     * @param user
     * @return
     */
    public boolean addUser(user user) {
        logger.info("进入addUser函数"+" 参数:"+" user-"+user);

        return userDAO.save(user);
    }
}
