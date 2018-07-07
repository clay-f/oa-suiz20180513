package com.f.test.service;

import com.f.core.pojo.Voucher;
import com.f.core.pojo.VoucherDetail;
import com.f.services.VoucherService;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;

import java.util.*;


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
        List<Voucher> list = Lists.newArrayList(new Voucher("foo", (float) 100));
        when(voucherService.getAll()).thenReturn(Collections.singletonList(list));
        assert voucherService.getAll().size() > 0;
    }

    @Test
    public void getVoucherById() {
        voucherService.get(51);
    }


    @Test
    public void addVoucher() {
        Voucher voucher = new Voucher("buy one hello book" + Objects.toString(System.currentTimeMillis()), (float) 0.00);
        voucher.getEmployee().setId(19);
        VoucherDetail voucherDetail = new VoucherDetail("get a car by 500$");
        voucher.setVoucherDetail(voucherDetail);
        voucherService.save(voucher);
    }

}