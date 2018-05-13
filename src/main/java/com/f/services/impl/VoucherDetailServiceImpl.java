package com.f.services.impl;

import com.f.dao.VoucherDetailDao;
import com.f.pojo.VoucherDetail;
import com.f.services.VoucherDetailService;
import com.f.services.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VoucherDetailServiceImpl implements VoucherDetailService {
    @Autowired(required = true)
    @Qualifier(value = "voucherDetailDao")
    private VoucherDetailDao voucherDetailDao;

    @Transactional
    @Override
    public boolean deleteVoucherDetailById(Integer id) {
       return voucherDetailDao.deleteVoucherDetailById(id) > 0;
    }

    @Transactional
    @Override
    public Integer saveVoucherDetail(VoucherDetail voucherDetail) {
        Integer saveState = -1;
        try {
            saveState = voucherDetailDao.saveVoucherDetail(voucherDetail);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return saveState;
    }

    @Transactional
    @Override
    public boolean deleteVoucherDetailByVoucherId(Integer id) {
        return voucherDetailDao.deleteVoucherDetailByVoucherId(id) > 0;
    }
}
