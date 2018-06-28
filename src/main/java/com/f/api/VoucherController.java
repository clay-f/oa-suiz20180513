package com.f.api;

import com.f.common.JResult;
import com.f.controller.BaseController;
import com.f.core.enums.EventType;
import com.f.core.event.EventContent;
import com.f.core.event.EventExecutor;
import com.f.pojo.Employee;
import com.f.pojo.Voucher;
import com.f.services.VoucherService;
import com.f.services.impl.AbstractGenericService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping(value = "/api/vouchers")
@RestController
public class VoucherController extends BaseController<Voucher, Integer> {
    @Autowired
    public VoucherController(@Qualifier("voucherService") AbstractGenericService abstractGenericService) {
        super(abstractGenericService);
    }

    @RequestMapping(value = "/{id}", method = {RequestMethod.PUT})
    public JResult update(@PathVariable(value = "id") Integer id, @ModelAttribute(value = "user") Voucher voucher, @SessionAttribute(required = true) Employee currentUser) throws JsonProcessingException {
        Voucher previousVoucher = (Voucher) getAbstractGenericService().get(voucher.getId());
        Map<String, Object> map = Maps.newHashMap();
        switch (currentUser.getOaPosition().getId()) {
            case 1:
                previousVoucher.getVoucherDetail().setDes(voucher.getVoucherDetail().getDes());
                previousVoucher.setItem(voucher.getItem());
                previousVoucher.setAccount(voucher.getAccount());
                break;
            case 2:
                map.put("type", Voucher.VoucherType.UPDATE_RESULT_STATE);
                map.put("id", voucher.getId());
                map.put("state", voucher.getCheckOutStateId());
                EventExecutor.fireEvent(new EventContent(getUserId().toString(), EventType.CHANGE_VOUCHER, map));
                break;
            case 3:
                map.put("type", Voucher.VoucherType.UPDATE_RESULT_STATE);
                map.put("id", voucher.getId());
                map.put("state", voucher.getCheckOutStateId());
                EventExecutor.fireEvent(new EventContent(getUserId().toString(), EventType.CHANGE_VOUCHER, map));
                break;
            case 4:
                map.put("type", Voucher.VoucherType.UPDATE_VOUCHER_STATE);
                map.put("id", voucher.getId());
                map.put("state", voucher.getCheckOutStateId());
                EventExecutor.fireEvent(new EventContent(getUserId().toString(), EventType.CHANGE_VOUCHER, map));
                break;
        }
        getAbstractGenericService().update(previousVoucher);
        return JResult.success("ok");
    }
}
