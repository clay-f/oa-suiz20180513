package com.f.services;

import com.f.pojo.Voucher;

import java.util.List;
import java.util.Map;

public interface VoucherService extends GenericService<Voucher, Integer> {

    List<Voucher> getVoucherByCondition(Map<String, Object> map);

    Integer size();
}
