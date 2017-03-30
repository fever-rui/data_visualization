package com.csu.data_visualization.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ZhangRui on 2017/3/22.
 */

@Entity
@Table(name = "data_record")
public class data_record {

    @Column(name = "id", nullable = false,length = 20)
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;//主键

    @Column(name="uid",nullable=false,length=20)
    private Integer uid;//用户id

    @Column(name="create_time")
    private String create_time;//创建时间

    @Column(name="data_info",nullable=false)
    private String data_info;//数据内容

    @Column(name="chart_type",length=20)
    private String chart_type;//图表类型:1、折线图，2、柱状图，3、扇形图，4、散点图，5、雷达图，6、地图。

    @Column(name="data_name", length=20)
    private String data_name;//数据名称

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getData_info() {
        return data_info;
    }

    public void setData_info(String data_info) {
        this.data_info = data_info;
    }

    public String getChart_type() {
        return chart_type;
    }

    public void setChart_type(String chart_type) {
        this.chart_type = chart_type;
    }

    public String getData_name() {
        return data_name;
    }

    public void setData_name(String data_name) {
        this.data_name = data_name;
    }
}
