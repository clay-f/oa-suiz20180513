package com.f.pojo;

import com.fasterxml.jackson.annotation.JsonView;

import java.sql.Timestamp;

public class BasePojo {
    private Integer id;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public BasePojo() {
    }

    public BasePojo(Integer id, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static interface BasePojoView {
    }

    @JsonView(BasePojoView.class)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @JsonView(BasePojoView.class)
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @JsonView(BasePojoView.class)
    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}
