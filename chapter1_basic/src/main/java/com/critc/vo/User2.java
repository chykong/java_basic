package com.critc.vo;

/**
 * Created by chykong on 2017/4/8.
 */
public class User2 {
    private String name;//
    private int id;//

    @Override
    public String toString() {
        return "User2{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
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

}
