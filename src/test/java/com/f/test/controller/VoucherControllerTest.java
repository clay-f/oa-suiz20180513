package com.f.test.controller;

import com.f.api.VoucherController;
import com.f.controller.BaseController;
import com.f.core.pojo.Voucher;
import com.f.services.VoucherService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringJUnitWebConfig(locations = {"classpath:applicationContext.xml"})
public class VoucherControllerTest {
    private MockMvc mockMvc;
    @Mock
    BaseController<Voucher, Integer> baseController;

    @Mock
    private VoucherService voucherService;

    @InjectMocks
    private VoucherController voucherController;

    @BeforeAll
    void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(voucherController).build();
    }

    @Test
    void addVoucher() throws Exception {
        Voucher voucher = new Voucher("buy some car", (float) 1000);
        voucher.getVoucherDetail().setDes("hello");
        Map<String, Object> map = Maps.newHashMap();
        map.put("item", "buy some car");
        map.put("account", "1000");
        map.put("des", ": ->");
        mockMvc.perform(post("/api/vouchers/save").contentType(MediaType.APPLICATION_JSON_UTF8)
        .content(new ObjectMapper().writeValueAsString(map)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
        verify(voucherService, times(1)).save(voucher);
    }

    @Test
    void getAll() throws Exception {
        List<Voucher> vouchers = Lists.newArrayList(new Voucher(1, "a", (float) 100), new Voucher(2,"b", (float) 200));
        when(voucherService.getAll()).thenReturn(Collections.singletonList(vouchers));
        mockMvc.perform(get("/api/vouchers/list").contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result[0].", is(1)))
                .andExpect(jsonPath("$.result", hasSize(2)));

    }
}
