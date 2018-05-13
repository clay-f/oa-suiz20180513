package com.f.pojo;

import java.io.Serializable;
import java.sql.Timestamp;

public class Voucher implements Serializable {
    private Integer id;
    private String item;
    private Float account;
    private Integer employeeId;
    private Integer checkOutStateId;
    private VoucherDetail voucherDetail;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public Voucher() {

    }

    public Voucher(String item, Float account, Integer employeeId) {
        this.item = item;
        this.account = account;
        this.employeeId = employeeId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Float getAccount() {
        return account;
    }

    public void setAccount(Float account) {
        this.account = account;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getCheckOutStateId() {
        return checkOutStateId;
    }

    public void setCheckOutStateId(Integer checkOutStateId) {
        this.checkOutStateId = checkOutStateId;
    }

    public VoucherDetail getVoucherDetail() {
        return voucherDetail;
    }

    public void setVoucherDetail(VoucherDetail voucherDetail) {
        this.voucherDetail = voucherDetail;
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
