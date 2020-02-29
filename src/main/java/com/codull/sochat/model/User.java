package com.codull.sochat.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: sochat
 * @description:
 * @author: anthony1314
 * @create: 2020-02-25 14:25
 **/
@Data
public class User implements Serializable {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    private String name;

    private String avatar;

    public void setName(String name) {
        this.name = name.trim();
    }
}
