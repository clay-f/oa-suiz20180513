package com.f.test.service;

import com.f.core.pojo.Dict;
import com.f.services.DictService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringJUnitWebConfig(locations = {"classpath:applicationContext.xml"})
public class DictTest {
    @Autowired
    @Qualifier(value = "dictService")
    private DictService dictService;

    @Test
    void save() {
        Dict dict = new Dict();
        dict.setDictName("审批测试2");
        dict.setValue(9);
        dictService.save(dict, (long)1);
    }
}
