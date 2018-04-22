package com.f.pojo;

import java.sql.Timestamp;

public class OaPosition {
    private Integer id;
    private String name;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public OaPosition() {
    }

    public OaPosition(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public OaPosition(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}
