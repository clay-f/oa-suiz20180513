package com.f.controller;

import com.f.common.JResult;
import com.f.pojo.Employee;
import com.f.pojo.Voucher;
import com.f.services.impl.AbstractGenericService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping(value = "/vouchers")
@RestController
public class VoucherController extends BaseController<Voucher, Integer> {
    @Autowired
    public VoucherController(@Qualifier("voucherService") AbstractGenericService abstractGenericService) {
        super(abstractGenericService);
    }

    @RequestMapping(value = "/{id}", method = {RequestMethod.PUT})
    public JResult update(@PathVariable(value = "id") Integer id, @ModelAttribute(value = "user") Voucher voucher, @SessionAttribute(required = true) Employee currentUser) throws JsonProcessingException {
        Voucher previousVoucher = (Voucher) getAbstractGenericService().get(voucher.getId());
        switch (currentUser.getOaPosition().getId()) {
            case 1:
                previousVoucher.getVoucherDetail().setDes(voucher.getVoucherDetail().getDes());
                previousVoucher.setItem(voucher.getItem());
                previousVoucher.setAccount(voucher.getAccount());
                break;
            case 2:
                previousVoucher.getCheckResult().setStateId(voucher.getCheckResult().getStateId());
                break;
            case 3:
                previousVoucher.getCheckResult().setStateId(voucher.getCheckResult().getStateId());
                break;
            case 4:
                previousVoucher.setCheckOutStateId(voucher.getCheckOutStateId());
                break;
        }
        getAbstractGenericService().update(previousVoucher);
        return JResult.success("ok");
    }
}
