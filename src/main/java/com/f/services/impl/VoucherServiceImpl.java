package com.f.services.impl;

import com.f.dao.GenericCrudMapper;
import com.f.dao.VoucherCheckResultDao;
import com.f.dao.VoucherDao;
import com.f.dao.VoucherDetailDao;
import com.f.helper.OutputJsonHelper;
import com.f.pojo.Voucher;
import com.f.pojo.VoucherCheckResult;
import com.f.pojo.VoucherDetail;
import com.f.services.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class VoucherServiceImpl extends GenericCrudService<Voucher, Integer> implements VoucherService {
    @Autowired
    public VoucherServiceImpl(@Qualifier("voucherDao") GenericCrudMapper mapper) {
        super(mapper);
        this.voucherDao = (VoucherDao) mapper;
    }

    private VoucherDao voucherDao;

    private OutputJsonHelper outputJsonHelper = OutputJsonHelper.getJsonOutputInstance();

    @Autowired
    private VoucherCheckResultDao voucherCheckResultDao;

    @Autowired(required = true)
    @Qualifier(value = "voucherDetailDao")
    private VoucherDetailDao voucherDetailDao;


    @Override
    public Integer size() {
        return mapper.getAll().size();
    }


    @Transactional(readOnly = true)
    @Override
    public List<Voucher> getVoucherByCondition(Map<String, Object> map) {
        List<Voucher> voucherList = null;
        voucherList = voucherDao.getVoucherAndDetailByConditions(map);
        return voucherList;
    }

    @Transactional
    @Override
    public void update(Voucher voucher) {
        super.update(voucher);
        voucherDetailDao.update(voucher.getVoucherDetail());
        voucherCheckResultDao.update(voucher.getCheckResult());
    }

    @Transactional
    @Override
    public void save(Voucher voucher) {
        super.save(voucher);
        Integer id = voucher.getId();
        System.out.println("save voucher should catch id: " + id);
        voucher.getVoucherDetail().setVoucherId(id);
        voucherDetailDao.insert(voucher.getVoucherDetail());
        voucher.getCheckResult().setVoucherId(id);
        voucherCheckResultDao.insert(voucher.getCheckResult());
    }
}
