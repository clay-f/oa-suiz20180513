package com.f.test.service;

import com.f.core.pojo.Dict;
import com.f.services.DictService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;

import java.util.HashMap;
import java.util.Map;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringJUnitWebConfig(locations = {"classpath:applicationContext.xml"})
public class DictTest {
    @Autowired
    @Qualifier(value = "dictService")
    private DictService dictService;

    @Test
    void save() {
        Dict dict = new Dict();
        dict.setDictName("审批测试");
        dict.setValue(0);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("dict", dict);
        map.put("dictTypeId", 1);
        dictService.save(map);
    }
}
