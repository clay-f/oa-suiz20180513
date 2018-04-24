package com.f.dao;

import com.f.pojo.Voucher;

import java.util.List;

public interface VoucherDao {
    List<Voucher> getAllVouchers();

    Voucher getVoucherById(Integer id);

    void deleteVoucherById(Integer id);

    Integer size();

    void saveVoucher(Voucher voucher);
}
