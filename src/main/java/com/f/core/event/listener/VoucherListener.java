package com.f.core.event.listener;

import com.f.core.enums.EventType;
import com.f.core.event.EventContent;
import com.f.core.event.handler.AbstractEventHandler;
import com.f.pojo.Voucher;
import com.f.services.VoucherService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class VoucherListener extends AbstractEventHandler {
    @Resource(name = "voucherService")
    private VoucherService voucherService;

    public VoucherListener(EventType eventTypes) {
        super(eventTypes);
    }

    @Override
    public void handle(EventContent eventContent) {
        Voucher.VoucherType voucherType = eventContent.getValue("type");
        if (voucherType != null) {
            switch (voucherType) {
                case UPDATE_RESULT_STATE:
                    break;
                case UPDATE_VOUCHER_STATE:
                    break;
                default:
                    break;
            }
        }
    }
}
