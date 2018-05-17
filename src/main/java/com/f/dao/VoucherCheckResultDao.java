package com.f.dao;

import com.f.pojo.VoucherCheckResult;

import java.util.List;
import java.util.Map;

public interface VoucherCheckResultDao {
    Integer deleteVoucherCheckResultByVoucherId(Integer id);

    Integer save(VoucherCheckResult result);

    Integer update(VoucherCheckResult result);

    List<VoucherCheckResult> getCheckResultByConditions(Map<String, Object> map);
}
