package com.f.dao;

import com.f.core.pojo.VoucherCheckResult;

import java.util.List;
import java.util.Map;

public interface VoucherCheckResultDao extends GenericDao<VoucherCheckResult, Integer> {
    List<VoucherCheckResult> getCheckResultByConditions(Map<String, Object> map);
}
