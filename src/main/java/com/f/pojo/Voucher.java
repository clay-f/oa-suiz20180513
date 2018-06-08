package com.f.pojo;

import com.fasterxml.jackson.annotation.JsonView;


public class Voucher extends BasePojo {
    private String item;
    private Float account;
    private Integer employeeId;
    private Integer checkOutStateId;
    private VoucherDetail voucherDetail = new VoucherDetail();
    private VoucherCheckResult checkResult = new VoucherCheckResult();


    public Voucher() {

    }

    public Voucher(String item, Float account, Integer employeeId) {
        this.item = item;
        this.account = account;
        this.employeeId = employeeId;
    }

    public static interface VoucherPojoView extends VoucherDetail.VoucherDetailPojoView, VoucherCheckResult.VoucherCheckResultPojoView {

    }

    @JsonView(VoucherPojoView.class)
    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    @JsonView(VoucherPojoView.class)
    public Float getAccount() {
        return account;
    }

    public void setAccount(Float account) {
        this.account = account;
    }

    @JsonView(VoucherPojoView.class)
    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    @JsonView(VoucherPojoView.class)
    public Integer getCheckOutStateId() {
        return checkOutStateId;
    }

    public void setCheckOutStateId(Integer checkOutStateId) {
        this.checkOutStateId = checkOutStateId;
    }

    @JsonView(VoucherPojoView.class)
    public VoucherDetail getVoucherDetail() {
        return voucherDetail;
    }

    public void setVoucherDetail(VoucherDetail voucherDetail) {
        this.voucherDetail = voucherDetail;
    }

    @JsonView(VoucherPojoView.class)
    public VoucherCheckResult getCheckResult() {
        return checkResult;
    }

    public void setCheckResult(VoucherCheckResult checkResult) {
        this.checkResult = checkResult;
    }
}
