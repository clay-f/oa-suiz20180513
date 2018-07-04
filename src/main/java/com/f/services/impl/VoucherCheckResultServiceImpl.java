package com.f.services.impl;

import com.f.dao.VoucherCheckResultDao;
import com.f.core.pojo.VoucherCheckResult;
import com.f.services.VoucherCheckResultService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;

@Service
public class VoucherCheckResultServiceImpl implements VoucherCheckResultService {
    @Resource(name = "voucherCheckResultDao")
    private VoucherCheckResultDao voucherCheckResultDao;

    @Override
    public boolean save(VoucherCheckResult result) {
        voucherCheckResultDao.insert(result);
        return true;
    }

    @Override
    public boolean deleteVoucherCheckResult(Integer id) {
        voucherCheckResultDao.delete(id);
        return true;
    }

    @Override
    public boolean updateVoucherCheckResult(VoucherCheckResult voucherCheckResult) {
        voucherCheckResult.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        voucherCheckResultDao.update(voucherCheckResult);
        return true;
    }
}
