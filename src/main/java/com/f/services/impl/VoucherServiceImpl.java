package com.f.services.impl;

import com.f.dao.VoucherDao;
import com.f.dao.VoucherDetailDao;
import com.f.helper.OutputJsonHelper;
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
    private OutputJsonHelper outputJsonHelper = OutputJsonHelper.getJsonOutputInstance();
    @Autowired(required = true)
    @Qualifier(value = "voucherDao")
    private VoucherDao voucherDao;

    @Autowired(required = true)
    @Qualifier(value = "voucherDetailDao")
    private VoucherDetailDao voucherDetailDao;

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
    public Integer saveVoucher(Voucher v) {
        Integer voucherPrimaryKey = -1;
        try {
            voucherDao.saveVoucher(v);
            voucherPrimaryKey = v.getId();
            v.getVoucherDetail().setVoucherId(voucherPrimaryKey);
            voucherDetailDao.saveVoucherDetail(v.getVoucherDetail());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return voucherPrimaryKey;
    }

    @Transactional
    @Override
    public boolean deleteVoucherById(Integer id) {
        try {
            Voucher tmpVoucher = voucherDao.getVoucherById(id);
            System.out.println(outputJsonHelper.outputJsonVal(tmpVoucher));
            Integer voucherDetailId = tmpVoucher.getVoucherDetail().getVoucherId();
            System.out.println("***********************");
            System.out.println("id val: " + voucherDetailId);
            if (voucherDetailId != null) {
                System.out.println("will delete voucher_detail, id is: " + voucherDetailId);
                voucherDetailDao.deleteVoucherDetailById(voucherDetailId);
            }
            System.out.println("**********************&");
            voucherDao.deleteVoucherById(tmpVoucher.getId());
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
