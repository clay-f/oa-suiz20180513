package com.f.dao;

import com.f.pojo.VoucherDetail;

public interface VoucherDetailDao {
    Integer saveVoucherDetail(VoucherDetail VoucherDetail);

    Integer deleteVoucherDetailById(Integer id);

    Integer deleteVoucherDetailByVoucherId(Integer id);

    Integer update(VoucherDetail voucherDetail);
}
