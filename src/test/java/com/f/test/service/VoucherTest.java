package com.f.test.service;

import com.f.pojo.Voucher;
import com.f.pojo.VoucherDetail;
import com.f.services.VoucherDetailService;
import com.f.services.VoucherService;
import com.f.test.TestHelper;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;


public class VoucherTest {
    private VoucherService voucherService = (VoucherService) TestHelper.getInstance().getBean("voucherService");
    private VoucherDetailService voucherDetailService = (VoucherDetailService) TestHelper.getInstance().getBean("voucherDetailServiceImpl");

    @Test
    public void getVouchersList() {
        assert voucherService != null;
        assert voucherService.getAll().size() > 0;
    }

    @Test
    public void getVoucherById() {
        voucherService.get(51);
    }

    @Test
    public void getSize() {
        assert voucherService.size() > 0;
    }

    @Test
    public void addVoucher() {
        Voucher voucher = new Voucher("jany get a car" + Objects.toString(System.currentTimeMillis()), (float) 0.00, 1);
        VoucherDetail voucherDetail = new VoucherDetail("get a car by 500$");
        voucher.setVoucherDetail(voucherDetail);
        voucherService.save(voucher);
    }

    @Test
    public void deleteVoucher() {
        List<Voucher> employeeList = voucherService.getAll();
//        assert voucherService.deleteVoucherById(employeeList.get(0).getId());
    }

    @Test
    public void updateVoucher() {
        List<Voucher> vouchers = voucherService.getAll();
        voucherService.update(vouchers.get(0));
    }

    @Test
    public void getVoucherByOaPositionId() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userId", 19);
        assert voucherService.getVoucherByCondition(map).size() > 0;
    }
}