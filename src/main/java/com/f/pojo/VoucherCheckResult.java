package com.f.pojo;

import java.sql.Timestamp;

public class VoucherCheckResult {
    private Integer id;
    private Integer voucherId;
    private Integer whoCheckId;
    private Integer stateId;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public VoucherCheckResult() {
        
    }

    public VoucherCheckResult(Integer voucherId, Integer whoCheckId) {
        this.voucherId = voucherId;
        this.whoCheckId = whoCheckId;
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

    public Integer getWhoCheckId() {
        return whoCheckId;
    }

    public void setWhoCheckId(Integer whoCheckId) {
        this.whoCheckId = whoCheckId;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
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
