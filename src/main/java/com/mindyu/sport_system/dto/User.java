package com.mindyu.sport_system.dto;

import java.io.Serializable;

public class User implements Serializable{

    private Integer id;//
    private String userName;
    private String avator;//
    private String email;//

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setAvator(String avator) {
        this.avator = avator;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getAvator() {
        return avator;
    }

    public String getEmail() {
        return email;
    }

    public User(com.mindyu.sport_system.pojo.User user){
        this.id = user.getId();
        this.userName = user.getUserName();
        this.avator = user.getAvator();
        this.email = user.getEmail();
    }
}
