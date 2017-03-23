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
    private Integer id;

    @Column(name="uid",nullable=false,length=20)
    private Integer uid;

    @Column(name="create_time",nullable=false,length=20)
    private Date create_time;

    @Column(name="data_info",nullable=false,length=20)
    private Date data_info;

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

    public Date getData_info() {
        return data_info;
    }

    public void setData_info(Date data_info) {
        this.data_info = data_info;
    }
}
