package com.f.services.impl;

import com.f.dao.GenericMapper;
import com.f.dao.VoucherDetailDao;
import com.f.core.pojo.VoucherDetail;
import com.f.services.VoucherDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VoucherDetailServiceImpl extends AbstractGenericService<VoucherDetail, Integer> implements VoucherDetailService {
    @Autowired
    public VoucherDetailServiceImpl(@Qualifier("voucherDetailDao") GenericMapper mapper) {
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
