package com.f.pojo;

import com.fasterxml.jackson.annotation.JsonView;

public class VoucherDetail extends BasePojo {
    private Integer voucherId;
    private String des;

    public VoucherDetail() {

    }

    public VoucherDetail(String des) {
        this.des = des;
    }

    public VoucherDetail(Integer voucherId, String des) {
        this.voucherId = voucherId;
        this.des = des;
    }

    public static interface VoucherDetailPojoView {

    }

    @JsonView(Voucher.VoucherPojoView.class)
    public Integer getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(Integer voucherId) {
        this.voucherId = voucherId;
    }

    @JsonView(Voucher.VoucherPojoView.class)
    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
