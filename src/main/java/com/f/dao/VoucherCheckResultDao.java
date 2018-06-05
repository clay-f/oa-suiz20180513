package com.f.dao;

import com.f.pojo.VoucherCheckResult;

import java.util.List;
import java.util.Map;

public interface VoucherCheckResultDao extends GenericCrudMapper<VoucherCheckResult, Integer> {
    List<VoucherCheckResult> getCheckResultByConditions(Map<String, Object> map);
}
