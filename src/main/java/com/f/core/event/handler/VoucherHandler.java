package com.f.core.event.handler;

import com.f.core.enums.EventType;
import com.f.core.event.EventContent;
import com.f.services.VoucherService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class VoucherHandler extends AbstractEventHandler {
    @Resource(name = "voucherService")
    private VoucherService voucherService;

    public VoucherHandler(EventType eventType) {
        super(eventType);
    }

    @Override
    public void handle(EventContent eventContent) {

    }
}
