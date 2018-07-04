package com.f.dao;

import com.f.core.pojo.VoucherDetail;

public interface VoucherDetailDao extends GenericMapper<VoucherDetail, Integer> {
    Integer deleteVoucherDetailByVoucherId(Integer id);
}
