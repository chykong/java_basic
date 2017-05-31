package com.critc.model;

/**
 * Created by 孔垂云 on 2017/5/21.
 */
public class User {
    private String[] links;
    private String[] likes;

    public String[] getLikes() {
        return likes;
    }

    public void setLikes(String[] likes) {
        this.likes = likes;
    }

    public String[] getLinks() {
        return links;
    }

    public void setLinks(String[] links) {
        this.links = links;
    }
}
