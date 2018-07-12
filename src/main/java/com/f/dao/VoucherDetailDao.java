package com.f.dao;

import com.f.core.pojo.VoucherDetail;

public interface VoucherDetailDao extends GenericDao<VoucherDetail, Integer> {
    Integer deleteVoucherDetailByVoucherId(Integer id);
}
