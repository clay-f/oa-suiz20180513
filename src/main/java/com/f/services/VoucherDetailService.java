package com.f.services;


import com.f.core.pojo.VoucherDetail;

public interface VoucherDetailService extends GenericService<VoucherDetail, Integer> {
    boolean deleteVoucherDetailByVoucherId(Integer id);
}
