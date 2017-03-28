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
    private Date create_time;//创建时间

    @Column(name="data_info",nullable=false)
    private String data_info;//数据内容

    @Column(name="data_type")
    private Integer data_type;//图表类型

    @Column(name="data_name")
    private Integer data_name;//数据名称

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

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getData_info() {
        return data_info;
    }

    public void setData_info(String data_info) {
        this.data_info = data_info;
    }

    public Integer getData_type() {
        return data_type;
    }

    public void setData_type(Integer data_type) {
        this.data_type = data_type;
    }

    public Integer getData_name() {
        return data_name;
    }

    public void setData_name(Integer data_name) {
        this.data_name = data_name;
    }
}
