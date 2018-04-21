package com.f.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/vouchers")
@Controller
public class VoucherController {
    @RequestMapping(value = "/index")
    public String index() {
        System.out.println("catch voucher controller method");
        return "/vouchers/index";
    }
}
