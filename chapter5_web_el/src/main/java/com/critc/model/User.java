package com.critc.model;

/**
 * Created by 孔垂云 on 2017/5/21.
 */
public class User {
    private String gender;
    private String name;//

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public User(String name) {
        this.name = name;
    }

    public User() {
    }
}
