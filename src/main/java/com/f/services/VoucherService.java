package com.f.services;

import com.f.pojo.Voucher;

import java.util.List;
import java.util.Map;

public interface VoucherService {
    List<Voucher> getAllVouchers();

    List<Voucher> getVoucherByCondition(Map<String, Object> map);

    Voucher getVoucherById(Integer id);

    Integer size();

    Integer saveVoucher(Voucher v);

    boolean deleteVoucherById(Integer id);

    boolean updateVoucher(Voucher voucher);
}
