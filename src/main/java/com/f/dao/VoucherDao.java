package com.f.dao;

import com.f.pojo.Voucher;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface VoucherDao extends GenericMapper<Voucher, Integer> {
    List<Voucher> getVoucherAndDetailByConditions(Map<String, Object> map);

    Integer size();

    void updateVoucherState(@Param("id") String voucherId, @Param("state") Integer state);

    void updateVoucherCheckResultState(@Param("id") String voucherId, @Param("state") Integer state);
}
