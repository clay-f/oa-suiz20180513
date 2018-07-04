package com.f.services;

import com.f.core.pojo.VoucherCheckResult;

public interface VoucherCheckResultService {
    boolean deleteVoucherCheckResult(Integer id);

    boolean save(VoucherCheckResult result);

    boolean updateVoucherCheckResult(VoucherCheckResult voucherCheckResult);
}
