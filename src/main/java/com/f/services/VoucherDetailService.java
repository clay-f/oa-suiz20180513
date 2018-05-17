package com.f.services;


import com.f.pojo.VoucherDetail;

public interface VoucherDetailService {
    Integer saveVoucherDetail(VoucherDetail voucherDetail);

    boolean deleteVoucherDetailById(Integer id);

    boolean deleteVoucherDetailByVoucherId(Integer id);

    boolean updateVoucherDetail(VoucherDetail voucherDetail);
}
