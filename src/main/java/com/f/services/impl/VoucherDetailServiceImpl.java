package com.f.services.impl;

import com.f.dao.GenericCrudMapper;
import com.f.dao.VoucherDetailDao;
import com.f.pojo.VoucherDetail;
import com.f.services.VoucherDetailService;
import com.f.services.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

@Service
public class VoucherDetailServiceImpl extends GenericCrudService<VoucherDetail, Integer> implements VoucherDetailService {
    @Autowired
    public VoucherDetailServiceImpl(@Qualifier("voucherDetailDao") GenericCrudMapper mapper) {
        super(mapper);
        voucherDetailDao = (VoucherDetailDao) mapper;
    }

    private VoucherDetailDao voucherDetailDao;

    @Transactional
    @Override
    public boolean deleteVoucherDetailByVoucherId(Integer id) {
        return voucherDetailDao.deleteVoucherDetailByVoucherId(id) > 0;
    }
}
