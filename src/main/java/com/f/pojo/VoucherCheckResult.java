package com.f.pojo;

import com.fasterxml.jackson.annotation.JsonView;

public class VoucherCheckResult extends BasePojo {
    private Integer voucherId;
    private Integer whoCheckId;
    private Integer stateId;

    public VoucherCheckResult() {

    }

    public VoucherCheckResult(Integer voucherId, Integer whoCheckId) {
        this.voucherId = voucherId;
        this.whoCheckId = whoCheckId;
    }

    public static interface VoucherCheckResultPojoView {

    }

    @JsonView(VoucherCheckResultPojoView.class)
    public Integer getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(Integer voucherId) {
        this.voucherId = voucherId;
    }

    @JsonView(VoucherCheckResultPojoView.class)
    public Integer getWhoCheckId() {
        return whoCheckId;
    }

    public void setWhoCheckId(Integer whoCheckId) {
        this.whoCheckId = whoCheckId;
    }

    @JsonView(VoucherCheckResultPojoView.class)
    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }
}
