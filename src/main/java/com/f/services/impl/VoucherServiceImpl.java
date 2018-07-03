package com.f.services.impl;

import com.f.core.event.EventContent;
import com.f.dao.GenericMapper;
import com.f.dao.VoucherCheckResultDao;
import com.f.dao.VoucherDao;
import com.f.dao.VoucherDetailDao;
import com.f.helper.OutputJsonHelper;
import com.f.pojo.Voucher;
import com.f.services.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service("voucherService")
public class VoucherServiceImpl extends AbstractGenericService<Voucher, Integer> implements VoucherService {
    private VoucherDao voucherDao;

    @Autowired
    private VoucherCheckResultDao voucherCheckResultDao;

    @Autowired(required = true)
    @Qualifier(value = "voucherDetailDao")
    private VoucherDetailDao voucherDetailDao;

    @Autowired
    public VoucherServiceImpl(@Qualifier("voucherDao") GenericMapper mapper) {
        super(mapper);
        this.voucherDao = (VoucherDao) mapper;
    }

    @Transactional(readOnly = true)
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

    @Transactional
    @Override
    public void updateVoucherState(String userId, EventContent eventContent, Voucher.VoucherType voucherType) {
        userId = userId.intern();
        synchronized (userId) {
            switch (voucherType) {
                case UPDATE_VOUCHER_STATE:
                    voucherDao.updateVoucherState(eventContent.getValue("id"), eventContent.getValue("state"));
                    break;
                case UPDATE_RESULT_STATE:
                    voucherDao.updateVoucherCheckResultState(eventContent.getValue("id"), eventContent.getValue("state"));
                    break;
                default:
                    break;
            }
        }
    }
}
