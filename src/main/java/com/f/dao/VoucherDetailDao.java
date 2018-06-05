package com.f.dao;

import com.f.pojo.VoucherDetail;

public interface VoucherDetailDao extends GenericCrudMapper<VoucherDetail, Integer> {
    Integer deleteVoucherDetailByVoucherId(Integer id);
}
