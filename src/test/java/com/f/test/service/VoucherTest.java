package com.f.test.service;

import com.f.core.pojo.Voucher;
import com.f.core.pojo.VoucherDetail;
import com.f.services.VoucherDetailService;
import com.f.services.VoucherService;
import com.f.test.TestHelper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;


import static org.mockito.Mockito.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringJUnitWebConfig(locations = {"classpath:applicationContext.xml"})
public class VoucherTest {
    @Mock
    private VoucherService voucherService;
    @BeforeAll
    void setup() {
        MockitoAnnotations.initMocks(this);
    }

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
        Voucher voucher = new Voucher("buy one hello book" + Objects.toString(System.currentTimeMillis()), (float) 0.00);
        voucher.getEmployee().setId(19);
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