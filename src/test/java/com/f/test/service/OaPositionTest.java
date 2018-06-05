package com.f.test.service;

import com.f.services.OaPositionService;
import com.f.test.TestHelper;
import org.junit.jupiter.api.Test;

public class OaPositionTest {
    private OaPositionService oaPositionService = (OaPositionService) TestHelper.getInstance().getBean("oaPositionServiceImpl");
    @Test
    public void getAllPosition() {
        assert oaPositionService.getAll().size() > 0;
    }
}
