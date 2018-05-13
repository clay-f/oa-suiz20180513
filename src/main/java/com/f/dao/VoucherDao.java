package com.f.dao;

import com.f.pojo.Voucher;

import java.util.List;
import java.util.Map;

public interface VoucherDao {
    List<Voucher> getAllVouchers();

    List<Voucher> getVoucherAndDetailByConditions(Map<String, Object> map);

    Voucher getVoucherById(Integer id);

    void deleteVoucherById(Integer id);

    Integer size();

    Integer saveVoucher(Voucher voucher);

    Integer updateVoucher(Voucher voucher);
}
