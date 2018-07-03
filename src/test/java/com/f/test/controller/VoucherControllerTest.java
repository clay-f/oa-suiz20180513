package com.f.test.controller;

import com.f.api.VoucherController;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Map;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:springmvc-servlet.xml"})
public class VoucherControllerTest {
    private MockMvc mockMvc;

    @Autowired
    @Qualifier(value = "voucherController")
    private VoucherController voucherController;

    @BeforeAll
    void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(voucherController).build();

    }

    @Test
    void addVoucher() throws Exception {
        Map<String, String> map = Maps.newHashMap();
        map.put("item", "buy cpu 8700k");
        map.put("account", "100.00");
        map.put("des", "fast run");
        mockMvc.perform(MockMvcRequestBuilders.
                post("/api/vouchers/save").
                contentType(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(map)));
    }
}
