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
        try {
            voucherList = voucherDao.getVoucherAndDetailByConditions(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return voucherList;
    }
}
