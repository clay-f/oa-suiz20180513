package com.f.services.impl;

import com.f.dao.VoucherDao;
import com.f.pojo.Voucher;
import com.f.services.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class VoucherServiceImpl implements VoucherService {
    @Autowired(required = true)
    @Qualifier(value = "voucherDao")
    private VoucherDao voucherDao;

    @Transactional
    @Override
    public List<Voucher> getAllVouchers() {
        List<Voucher> vouchers = new ArrayList<Voucher>();
        try {
            vouchers = voucherDao.getAllVouchers();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vouchers;
    }

    @Transactional
    @Override
    public Voucher getVoucherById(Integer id) {
        return voucherDao.getVoucherById(id);
    }

    @Transactional
    @Override
    public Integer size() {
        return voucherDao.size();
    }

    @Transactional
    @Override
    public boolean saveVoucher(Voucher v) {
        try {
            voucherDao.saveVoucher(v);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Transactional
    @Override
    public boolean deleteVoucherById(Integer id) {
        try {
            voucherDao.deleteVoucherById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Transactional
    @Override
    public boolean updateVoucher(Voucher voucher) {
        try {
            voucher.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
            voucherDao.updateVoucher(voucher);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
