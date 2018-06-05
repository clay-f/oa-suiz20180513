package com.f.dao;

import com.f.pojo.Voucher;

import java.util.List;
import java.util.Map;

public interface VoucherDao extends GenericCrudMapper<Voucher, Integer> {
    List<Voucher> getVoucherAndDetailByConditions(Map<String, Object> map);

    Integer size();
}
