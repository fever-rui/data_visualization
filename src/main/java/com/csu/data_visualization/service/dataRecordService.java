package com.csu.data_visualization.service;

import com.csu.data_visualization.dao.DataRecordDAO;
import com.csu.data_visualization.model.Page;
import com.csu.data_visualization.model.data_record;
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

    /**
     * 根据id获取记录
     * @param id
     * @return
     */
    public List<data_record> getRecordByUid(Integer id) {
        logger.info("进入getRecordByUid函数"+" 参数:"+" id-"+id);
        return dataRecordDAO.getRecordByUid(id);
    }

    public List<data_record> getAllRecordByUid(Integer id,Page page) {
        logger.info("进入getAllRecordByUid函数"+" 参数:"+" id-"+id);
        return dataRecordDAO.getAllRecordByUid(id, page);
    }

    public Integer getRecordSize(Integer id) {
        logger.info("进入getRecordSize函数"+" 参数:"+" id-"+id);
        return dataRecordDAO.getRecordSize(id);
    }
}
