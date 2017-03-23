package com.csu.data_visualization.service;

import com.csu.data_visualization.dao.DataRecordDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ZhangRui on 2017/3/23.
 */
@Service("dataRecordService")
@Transactional
public class dataRecordService {
    @Autowired
    private DataRecordDAO dataRecordDAO;
}
