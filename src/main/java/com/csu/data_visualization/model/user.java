package com.csu.data_visualization.model;

import javax.persistence.*;

/**
 * Created by ZhangRui on 2017/3/10.
 */
@Entity
@Table(name="user")
public class user {

    @Column(name="id", nullable=false,length=20)
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;//id，主键

    @Column(name="account",nullable=false,length=20)
    private String account;//账户

    @Column(name="name",length=20)
    private String name;//用户名称

    @Column(name="password",length=20)
    private String password;//密码

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
