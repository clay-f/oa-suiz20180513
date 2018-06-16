package com.f.test.service;

import com.f.services.OaPositionService;
import com.f.test.TestHelper;
import org.junit.jupiter.api.Test;

public class OaPositionTest {
    private OaPositionService oaPositionService = (OaPositionService) TestHelper.getInstance().getBean("oaPositionService");
    @Test
    public void getAllPosition() {
        assert oaPositionService.getAll().size() > 0;
    }
}
