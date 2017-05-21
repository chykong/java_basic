package com.critc.model;

/**
 * Created by 孔垂云 on 2017/5/21.
 */
public class Person {
    private int age;//
    private String name;//
    private Address address;//地址
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
