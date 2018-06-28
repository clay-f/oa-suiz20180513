package com.f.core.event.handler;

import com.f.core.enums.EventType;
import com.f.core.event.EventContent;
import com.f.pojo.Voucher;
import com.f.services.VoucherService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class VoucherHandler extends AbstractEventHandler {
    @Resource(name = "voucherService")
    private VoucherService voucherService;

    public VoucherHandler() {
        super(EventType.CHANGE_VOUCHER);
    }

    @Override
    public void handle(EventContent eventContent) {
        Voucher.VoucherType voucherType = eventContent.getValue("type");
        switch (voucherType) {
            case UPDATE_RESULT_STATE:
                voucherService.updateVoucherState(eventContent.getTargetId(), eventContent, voucherType);
                break;
            case UPDATE_VOUCHER_STATE:
                voucherService.updateVoucherState(eventContent.getTargetId(), eventContent, voucherType);
                break;
            default:
                break;
        }
    }
}
