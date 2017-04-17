package com.critc.vo;

/**
 * Created by chykong on 2017/4/8.
 */
public class User1 {
    private String name;//
    private int id;//
    private String pass;

    public User1() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPass() {
        return pass;
    }

    public User1(String name, int id, String pass) {
        this.name = name;
        this.id = id;
        this.pass = pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
