package com.f.pojo;

import java.sql.Timestamp;

public class VoucherDetail {
    private Integer id;
    private Integer voucherId;
    private String des;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public VoucherDetail() {

    }

    public VoucherDetail(String des) {
        this.des = des;
    }

    public VoucherDetail(Integer voucherId, String des) {
        this.voucherId = voucherId;
        this.des = des;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(Integer voucherId) {
        this.voucherId = voucherId;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
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
