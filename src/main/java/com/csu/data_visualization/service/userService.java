package com.csu.data_visualization.service;

import com.csu.data_visualization.dao.UserDAO;
import com.csu.data_visualization.model.user;
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
    @Autowired
    private UserDAO userDAO;
    public List<user> getUsers() {
        return userDAO.getUsers();
    }
}
