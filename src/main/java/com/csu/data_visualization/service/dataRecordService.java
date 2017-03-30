package com.csu.data_visualization.service;

import com.csu.data_visualization.dao.DataRecordDAO;
import com.csu.data_visualization.model.data_record;
import com.csu.data_visualization.util.hostUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ZhangRui on 2017/3/23.
 */
@Service("dataRecordService")
@Transactional
public class dataRecordService {

    private static final Logger logger=Logger.getLogger(dataRecordService.class);

    @Autowired
    private DataRecordDAO dataRecordDAO;

    /**
     * 添加新纪录
     * @param record
     * @return
     */
    public boolean addRecord(data_record record) {
        logger.info("进入addRecord函数"+" 参数:"+" record-"+record);

        return dataRecordDAO.save(record);
    }

    public List<data_record> getRecordByUid(Integer id) {
        logger.info("进入getRecordByUid函数"+" 参数:"+" id-"+id);
        return dataRecordDAO.getRecordByUid(id);
    }
}
