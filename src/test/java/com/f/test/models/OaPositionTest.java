package com.f.test.models;

import com.f.services.OaPositionService;
import com.f.test.TestHelper;
import org.junit.Test;

public class OaPositionTest {
    private OaPositionService oaPositionService = (OaPositionService) TestHelper.getInstance().getBean("oaPositionServiceImpl");
    @Test
    public void getAllPosition() {
        assert oaPositionService.getPositionList().size() > 0;
    }
}
