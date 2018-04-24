package com.f.services;

import com.f.pojo.Voucher;

import java.util.List;

public interface VoucherService {
    List<Voucher> getAllVouchers();

    Voucher getVoucherById(Integer id);

    Integer size();

    boolean saveVoucher(Voucher v);

    boolean deleteVoucherById(Integer id);

    boolean updateVoucher(Voucher voucher);
}
